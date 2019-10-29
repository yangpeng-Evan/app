package com.qf.service.impl;

import com.qf.entity.DevUser;
import com.qf.enums.AppEnum;
import com.qf.exception.AppException;
import com.qf.service.SendEmailService;
import com.qf.util.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author yangpeng
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.activeUrl}")
    private String activeUrl;

    @Value("${spring.mail.username}")
    private String from;
    @Override
    @Async
    public void sendEmail(DevUser devUser) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage,true);
            msgHelper.setFrom(from);
            msgHelper.addTo(devUser.getDevEmail());
            msgHelper.setSubject("用户激活邮件");
            String url = activeUrl + "/dev/user/active?email=" + Base64Utils.encode(devUser.getDevEmail()) + "&code=" + Base64Utils.encode(devUser.getDevCode());
            msgHelper.setText("text/html;charset=utf-8",devUser.getDevUsername() + ",您好<br /> 欢迎注册APP管理平台! 请点击链接进行激活:<a href='"+url+"'>"+url+"</a>");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new AppException(AppEnum.SEND_EMAIL_ERROR);
        }
    }
}
