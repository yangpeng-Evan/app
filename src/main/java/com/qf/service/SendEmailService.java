package com.qf.service;

import com.qf.entity.DevUser;

/**
 * @author yangpeng
 */
public interface SendEmailService {
    /**
     * 发送邮件接口
     */
    void sendEmail(DevUser devUser);
}
