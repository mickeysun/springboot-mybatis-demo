package com.megvii.qa.core.thread;


import com.megvii.qa.core.conf.QaTestAdminConfig;
import com.megvii.qa.core.trigger.TriggerTypeEnum;
import com.megvii.qa.core.util.I18nUtil;
import com.megvii.qa.model.ReturnT;
import com.megvii.qa.model.TaskInfo;
import com.megvii.qa.model.TaskLog;
import com.megvii.qa.model.TaskLogWithBLOBs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * job monitor instance
 *
 * @author xuxueli 2015-9-1 18:05:56
 */
public class JobFailMonitorHelper {
	private static Logger logger = LoggerFactory.getLogger(JobFailMonitorHelper.class);
	
	private static JobFailMonitorHelper instance = new JobFailMonitorHelper();
	public static JobFailMonitorHelper getInstance(){
		return instance;
	}

	// ---------------------- monitor ----------------------

	private Thread monitorThread;
	private volatile boolean toStop = false;
	public void start(){
		monitorThread = new Thread(new Runnable() {

			@Override
			public void run() {

				// monitor
				while (!toStop) {
					try {

						List<Integer> failLogIds = QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().findFailJobLogIds(1000);
						if (failLogIds!=null && !failLogIds.isEmpty()) {
							for (int failLogId: failLogIds) {

								// lock log
								int lockRet = QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().updateAlarmStatus(failLogId, 0, -1);
								if (lockRet < 1) {
									continue;
								}
								TaskLogWithBLOBs log = (TaskLogWithBLOBs)QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().selectByPrimaryKey(failLogId);
								TaskInfo info = QaTestAdminConfig.getAdminConfig().getXxlJobInfoDao().selectByPrimaryKey(log.getJobId());

								// 1、fail retry monitor
								if (log.getExecutorFailRetryCount() > 0) {
									JobTriggerPoolHelper.trigger(log.getJobId(), TriggerTypeEnum.RETRY, (log.getExecutorFailRetryCount()-1), null);
									String retryMsg = "<br><br><span style=\"color:#F39C12;\" > >>>>>>>>>>>"+ I18nUtil.getString("jobconf_trigger_type_retry") +"<<<<<<<<<<< </span><br>";
									log.setTriggerMsg(log.getTriggerMsg() + retryMsg);
									QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().updateByPrimaryKeyWithBLOBs(log);
								}

								// 2、fail alarm monitor
								int newAlarmStatus = 0;		// 告警状态：0-默认、-1=锁定状态、1-无需告警、2-告警成功、3-告警失败
								if (info!=null && info.getAlarmEmail()!=null && info.getAlarmEmail().trim().length()>0) {
									boolean alarmResult = true;
									try {
										alarmResult = failAlarm(info, log);
									} catch (Exception e) {
										alarmResult = false;
										logger.error(e.getMessage(), e);
									}
									newAlarmStatus = alarmResult?2:3;
								} else {
									newAlarmStatus = 1;
								}

								QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().updateAlarmStatus(failLogId, -1, newAlarmStatus);
							}
						}

						TimeUnit.SECONDS.sleep(10);
					} catch (Exception e) {
						if (!toStop) {
							logger.error(">>>>>>>>>>> xxl-job, job fail monitor thread error:{}", e);
						}
					}
				}

				logger.info(">>>>>>>>>>> xxl-job, job fail monitor thread stop");

			}
		});
		monitorThread.setDaemon(true);
		monitorThread.start();
	}

	public void toStop(){
		toStop = true;
		// interrupt and wait
		monitorThread.interrupt();
		try {
			monitorThread.join();
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
	}


	// ---------------------- alarm ----------------------

	// email alarm template
	private static final String mailBodyTemplate = "<h5>" + I18nUtil.getString("jobconf_monitor_detail") + "：</span>" +
			"<table border=\"1\" cellpadding=\"3\" style=\"border-collapse:collapse; width:80%;\" >\n" +
			"   <thead style=\"font-weight: bold;color: #ffffff;background-color: #ff8c00;\" >" +
			"      <tr>\n" +
			"         <td width=\"20%\" >"+ I18nUtil.getString("jobinfo_field_jobgroup") +"</td>\n" +
			"         <td width=\"10%\" >"+ I18nUtil.getString("jobinfo_field_id") +"</td>\n" +
			"         <td width=\"20%\" >"+ I18nUtil.getString("jobinfo_field_jobdesc") +"</td>\n" +
			"         <td width=\"10%\" >"+ I18nUtil.getString("jobconf_monitor_alarm_title") +"</td>\n" +
			"         <td width=\"40%\" >"+ I18nUtil.getString("jobconf_monitor_alarm_content") +"</td>\n" +
			"      </tr>\n" +
			"   </thead>\n" +
			"   <tbody>\n" +
			"      <tr>\n" +
			"         <td>{0}</td>\n" +
			"         <td>{1}</td>\n" +
			"         <td>{2}</td>\n" +
			"         <td>"+ I18nUtil.getString("jobconf_monitor_alarm_type") +"</td>\n" +
			"         <td>{3}</td>\n" +
			"      </tr>\n" +
			"   </tbody>\n" +
			"</table>";

	/**
	 * fail alarm
	 *
	 * @param jobLog1
	 */
	private boolean failAlarm(TaskInfo info, TaskLog jobLog1){
		boolean alarmResult = true;
        TaskLogWithBLOBs jobLog = (TaskLogWithBLOBs)jobLog1;
		// send monitor email
		if (info!=null && info.getAlarmEmail()!=null && info.getAlarmEmail().trim().length()>0) {

			String alarmContent = "Alarm Job LogId=" + jobLog.getId();
			if (jobLog.getTriggerCode() != ReturnT.SUCCESS_CODE) {
				alarmContent += "<br>TriggerMsg=<br>" + jobLog.getTriggerMsg();
			}
			if (jobLog.getHandleCode()>0 && jobLog.getHandleCode() != ReturnT.SUCCESS_CODE) {
				alarmContent += "<br>HandleCode=" + jobLog.getHandleMsg();
			}

			Set<String> emailSet = new HashSet<String>(Arrays.asList(info.getAlarmEmail().split(",")));
			for (String email: emailSet) {


				String personal = I18nUtil.getString("admin_name_full");
				String title = I18nUtil.getString("jobconf_monitor");
				String content = MessageFormat.format(mailBodyTemplate,

						info.getId(),
						info.getJobDesc(),
						alarmContent);


				// make mail
				try {
					MimeMessage mimeMessage = QaTestAdminConfig.getAdminConfig().getMailSender().createMimeMessage();

					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					helper.setFrom(QaTestAdminConfig.getAdminConfig().getEmailUserName(), personal);
					helper.setTo(email);
					helper.setSubject(title);
					helper.setText(content, true);

					QaTestAdminConfig.getAdminConfig().getMailSender().send(mimeMessage);
				} catch (Exception e) {
					logger.error(">>>>>>>>>>> xxl-job, job fail alarm email send error, JobLogId:{}", jobLog.getId(), e);

					alarmResult = false;
				}

			}
		}

		// TODO, custom alarm strategy, such as sms


		return alarmResult;
	}

}
