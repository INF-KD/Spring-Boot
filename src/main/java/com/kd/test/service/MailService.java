package com.kd.test.service;

import com.kd.test.model.Mail;
import com.kd.test.response.DataResponse;

public interface MailService {
    DataResponse sendEmail(Mail mail);
}
