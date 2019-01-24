package com.megvii.qa.core.conf;

import com.megvii.qa.dao.TaskInfoMapper;
import com.megvii.qa.dao.TaskLogMapper;
import com.megvii.qa.dao.TaskRegistryMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
public class QaTestAdminConfig implements InitializingBean {
    private static QaTestAdminConfig adminConfig = null;
    public static QaTestAdminConfig getAdminConfig() {
        return adminConfig;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        adminConfig = this;
    }

    // conf

    @Value("${xxl.job.login.username}")
    private String loginUsername;

    @Value("${xxl.job.login.password}")
    private String loginPassword;

    @Value("${xxl.job.i18n}")
    private String i18n;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${spring.mail.username}")
    private String emailUserName;

    // dao, service

    @Resource
    private TaskLogMapper xxlJobLogDao;
    @Resource
    private TaskInfoMapper xxlJobInfoDao;
    @Resource
    private TaskRegistryMapper xxlJobRegistryDao;


    @Resource
    private JavaMailSender mailSender;

    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getI18n() {
        return i18n;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public TaskLogMapper getXxlJobLogDao() {
        return xxlJobLogDao;
    }

    public TaskInfoMapper getXxlJobInfoDao() {
        return xxlJobInfoDao;
    }

    public TaskRegistryMapper getXxlJobRegistryDao() {
        return xxlJobRegistryDao;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

}
