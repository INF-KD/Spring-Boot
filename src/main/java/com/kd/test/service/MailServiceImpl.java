package com.kd.test.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.kd.test.model.Mail;
import com.kd.test.model.Response;
import com.kd.test.response.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    public DataResponse sendEmail(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setTo(mail.getTo());
            mimeMessageHelper.setText(mail.getText());

            mailSender.send(mimeMessageHelper.getMimeMessage());

            return new DataResponse<>("Mail sent successfully", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new DataResponse<>(e.getLocalizedMessage(), new Response(HttpStatus.BAD_REQUEST, "FAILED", null));
        }
    }

}
