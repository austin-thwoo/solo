package com.noah.solo.global.util;

import org.springframework.beans.factory.annotation.Value;
//

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component
public class MailUtil {

    private final JavaMailSender javaMailSender;

    private final String FROM_ADDRESS;

    public MailUtil(JavaMailSender javaMailSender,
                    @Value("${spring.mail.username}") String FROM_ADDRESS) {
        this.javaMailSender = javaMailSender;
        this.FROM_ADDRESS = FROM_ADDRESS;
    }


    public void sendAuthMail(AuthMailDto dto) {
        String targetEmail = dto.getTargetEmail();

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail, "", "UTF-8"));
            message.setFrom(new InternetAddress(FROM_ADDRESS, "SHARE-FIT", "UTF-8"));

            message.setSubject("[SHARE-FIT] 비밀번호 인증용 이메일");

            String text = dto.getAuthCode();

            message.setText(text, "UTF-8", "html");
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
