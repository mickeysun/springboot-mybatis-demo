package com.megvii.qa.core.trigger;


import com.megvii.qa.core.conf.QaTestAdminConfig;
import com.megvii.qa.core.util.I18nUtil;
import com.megvii.qa.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * xxl-job trigger
 * Created by xuxueli on 17/7/13.
 */
public class XxlJobTrigger {
    private static Logger logger = LoggerFactory.getLogger(XxlJobTrigger.class);

    /**
     * trigger job
     *
     * @param jobId
     * @param triggerType
     * @param failRetryCount
     * 			>=0: use this param
     * 			<0: use param from job info config
     *          null: use job param
     *          not null: cover job param
     */
    public static void trigger(int jobId, TriggerTypeEnum triggerType, int failRetryCount,String executorParam ) {
        // load data
        TaskInfo jobInfo = QaTestAdminConfig.getAdminConfig().getXxlJobInfoDao().selectByPrimaryKey(jobId);
        if (jobInfo == null) {
            logger.warn(">>>>>>>>>>>> trigger fail, jobId invalid，jobId={}", jobId);
            return;
        }
        if (executorParam != null) {
            jobInfo.setExecutorParam(executorParam);
        }
        int finalFailRetryCount = failRetryCount>=0?failRetryCount:jobInfo.getExecutorFailRetryCount();



        processTrigger(jobInfo, finalFailRetryCount, triggerType);


    }

    /**
     * @param jobInfo
     * @param finalFailRetryCount
     * @param triggerType
     */
    private static void processTrigger(TaskInfo jobInfo, int finalFailRetryCount, TriggerTypeEnum triggerType){

        // param

        // 1、save log-id
        TaskLogWithBLOBs jobLog = (TaskLogWithBLOBs)new TaskLog();
        jobLog.setJobId(jobInfo.getId());
        jobLog.setTriggerTime(new Date());
        QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().insert(jobLog);
        logger.debug(">>>>>>>>>>> xxl-job trigger start, jobId:{}", jobLog.getId());

        // 2、init trigger-param
        TriggerParam triggerParam = new TriggerParam();
        triggerParam.setJobId(jobInfo.getId());

        triggerParam.setExecutorParams(jobInfo.getExecutorParam());

        triggerParam.setExecutorTimeout(jobInfo.getExecutorTimeout());
        triggerParam.setLogId(jobLog.getId());
        triggerParam.setLogDateTim(jobLog.getTriggerTime().getTime());
        triggerParam.setGlueType(jobInfo.getGlueType());
        triggerParam.setGlueSource(jobInfo.getGlueSource());
        triggerParam.setGlueUpdatetime(jobInfo.getGlueUpdatetime().getTime());


        // 3、init address
        String address = null;


        // 4、trigger remote executor
        ReturnT<String> triggerResult = null;
//        if (address != null) {
//            triggerResult = runExecutor(triggerParam, address);
//        } else {
//            triggerResult = new ReturnT<String>(ReturnT.FAIL_CODE, null);
//        }

        // 5、collection trigger info
        StringBuffer triggerMsgSb = new StringBuffer();
        triggerMsgSb.append(I18nUtil.getString("jobconf_trigger_type")).append("：").append(triggerType.getTitle());
        triggerMsgSb.append("<br>").append(I18nUtil.getString("jobinfo_field_timeout")).append("：").append(jobInfo.getExecutorTimeout());
        triggerMsgSb.append("<br>").append(I18nUtil.getString("jobinfo_field_executorFailRetryCount")).append("：").append(finalFailRetryCount);

//        triggerMsgSb.append("<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>"+ I18nUtil.getString("jobconf_trigger_run") +"<<<<<<<<<<< </span><br>")
//                .append((routeAddressResult!=null&&routeAddressResult.getMsg()!=null)?routeAddressResult.getMsg()+"<br><br>":"").append(triggerResult.getMsg()!=null?triggerResult.getMsg():"");

        // 6、save log trigger-info

        jobLog.setExecutorParam(jobInfo.getExecutorParam());

        jobLog.setExecutorFailRetryCount(finalFailRetryCount);
        //jobLog.setTriggerTime();
        jobLog.setTriggerCode(triggerResult.getCode());
        jobLog.setTriggerMsg(triggerMsgSb.toString());
        QaTestAdminConfig.getAdminConfig().getXxlJobLogDao().updateByPrimaryKey(jobLog);

        logger.debug(">>>>>>>>>>> xxl-job trigger end, jobId:{}", jobLog.getId());
    }



}
