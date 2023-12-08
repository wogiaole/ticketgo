package com.ticketgo.pattern.observer;

import com.ticketgo.service.impl.EmailService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailObserver implements Observer {

    private final EmailService emailService;
    private final String email;
    private final String userName;

    public EmailObserver(EmailService emailService, String email, String userName) {
        this.emailService = emailService;
        this.email = email;
        this.userName = userName;
    }

    @Override
    public void update(String movieName) {
        //邮件模板
        String subject = "New Movie released!";
        String body = "Dear {{userName}},<br><br>" +
                "<b>{{movieName}}</b> is released, welcome to watch!<br><br>" +
                "thanks，<br>" +
                "TicketGo";
        body = body.replace("{{userName}}", userName);
        body = body.replace("{{movieName}}", movieName);

        emailService.sendEmail(email, subject, body);
        log.info("email: {}", email);
        log.info("email sent successfully");
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }
}
