package com.kd.test.controller;

import com.kd.test.model.Mail;
import com.kd.test.model.Message;
import com.kd.test.response.DataResponse;
import com.kd.test.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MailService mailer;

    @Value("${app.dev}")
    String dev;

    @GetMapping("/")
    public String Hola(){
        return "Hola, soy " + dev;
    }

    @GetMapping("/")
    public Message writeMessage(
            @RequestParam String message
    ) {
        logger.info(dev);
        return new Message(message);
    }

    @PostMapping("/sendmail")
    public DataResponse Mail(
            @RequestBody Mail mail
    ) {
        return mailer.sendEmail(mail);
    }
}
