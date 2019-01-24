package com.megvii.qa.model;

import java.util.Date;

public class TaskInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.id
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private Integer id;

    private String jobStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.job_cron
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String jobCron;

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.job_desc
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String jobDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.add_time
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private Date addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.update_time
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.author
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.alarm_email
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String alarmEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_param
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String executorParam;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_timeout
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private Integer executorTimeout;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_fail_retry_count
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private Integer executorFailRetryCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_type
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String glueType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_remark
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String glueRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_updatetime
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private Date glueUpdatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.child_jobid
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String childJobid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_source
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    private String glueSource;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.id
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.id
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.id
     *
     * @param id the value for QA_TEST_ORTZ_TRIGGER_INFO.id
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.job_cron
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.job_cron
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getJobCron() {
        return jobCron;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.job_cron
     *
     * @param jobCron the value for QA_TEST_ORTZ_TRIGGER_INFO.job_cron
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.job_desc
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.job_desc
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.job_desc
     *
     * @param jobDesc the value for QA_TEST_ORTZ_TRIGGER_INFO.job_desc
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.add_time
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.add_time
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.add_time
     *
     * @param addTime the value for QA_TEST_ORTZ_TRIGGER_INFO.add_time
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.update_time
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.update_time
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.update_time
     *
     * @param updateTime the value for QA_TEST_ORTZ_TRIGGER_INFO.update_time
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.author
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.author
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.author
     *
     * @param author the value for QA_TEST_ORTZ_TRIGGER_INFO.author
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.alarm_email
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.alarm_email
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getAlarmEmail() {
        return alarmEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.alarm_email
     *
     * @param alarmEmail the value for QA_TEST_ORTZ_TRIGGER_INFO.alarm_email
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setAlarmEmail(String alarmEmail) {
        this.alarmEmail = alarmEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_param
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.executor_param
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getExecutorParam() {
        return executorParam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_param
     *
     * @param executorParam the value for QA_TEST_ORTZ_TRIGGER_INFO.executor_param
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setExecutorParam(String executorParam) {
        this.executorParam = executorParam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_timeout
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.executor_timeout
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public Integer getExecutorTimeout() {
        return executorTimeout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_timeout
     *
     * @param executorTimeout the value for QA_TEST_ORTZ_TRIGGER_INFO.executor_timeout
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setExecutorTimeout(Integer executorTimeout) {
        this.executorTimeout = executorTimeout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_fail_retry_count
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.executor_fail_retry_count
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public Integer getExecutorFailRetryCount() {
        return executorFailRetryCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.executor_fail_retry_count
     *
     * @param executorFailRetryCount the value for QA_TEST_ORTZ_TRIGGER_INFO.executor_fail_retry_count
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setExecutorFailRetryCount(Integer executorFailRetryCount) {
        this.executorFailRetryCount = executorFailRetryCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_type
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.glue_type
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getGlueType() {
        return glueType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_type
     *
     * @param glueType the value for QA_TEST_ORTZ_TRIGGER_INFO.glue_type
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setGlueType(String glueType) {
        this.glueType = glueType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_remark
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.glue_remark
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getGlueRemark() {
        return glueRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_remark
     *
     * @param glueRemark the value for QA_TEST_ORTZ_TRIGGER_INFO.glue_remark
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setGlueRemark(String glueRemark) {
        this.glueRemark = glueRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_updatetime
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.glue_updatetime
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public Date getGlueUpdatetime() {
        return glueUpdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_updatetime
     *
     * @param glueUpdatetime the value for QA_TEST_ORTZ_TRIGGER_INFO.glue_updatetime
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setGlueUpdatetime(Date glueUpdatetime) {
        this.glueUpdatetime = glueUpdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.child_jobid
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.child_jobid
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getChildJobid() {
        return childJobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.child_jobid
     *
     * @param childJobid the value for QA_TEST_ORTZ_TRIGGER_INFO.child_jobid
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setChildJobid(String childJobid) {
        this.childJobid = childJobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_source
     *
     * @return the value of QA_TEST_ORTZ_TRIGGER_INFO.glue_source
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public String getGlueSource() {
        return glueSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QA_TEST_ORTZ_TRIGGER_INFO.glue_source
     *
     * @param glueSource the value for QA_TEST_ORTZ_TRIGGER_INFO.glue_source
     *
     * @mbggenerated Thu Jan 24 14:32:36 CST 2019
     */
    public void setGlueSource(String glueSource) {
        this.glueSource = glueSource;
    }
}