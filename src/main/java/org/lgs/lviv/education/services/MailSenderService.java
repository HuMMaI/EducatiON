package org.lgs.lviv.education.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    private static final Logger LOG = LoggerFactory.getLogger(MailSenderService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void send(String emailTo, String subject, String message){
        LOG.info("Sending email with subject={}", subject);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(emailTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        try {
            mailSender.send(simpleMailMessage);
        } catch (MailException e) {
            String errorMessage = String.format("Can't send email with subject=%s", subject);
            LOG.error(message, e);
        }
    }
}
