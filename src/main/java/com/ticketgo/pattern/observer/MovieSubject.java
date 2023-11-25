package com.ticketgo.pattern.observer;

import com.ticketgo.service.impl.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MovieSubject implements Subject {

    @Autowired
    private EmailService emailService;
    private List<Observer> userList = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        userList.add(observer);

    }

    @Override
    public void notifyObserver(String movieName) {
        for (Observer user : userList) {
            String to = user.getEmail(); // 用户邮箱

            String userName = user.getUserName();//用户名

            //邮件模板
            String subject = "New Movie released!";
            String body = "Dear {{userName}},<br><br>" +
                    "<b>{{movieName}}</b> is released, welcome to watch!<br><br>" +
                    "thanks，<br>" +
                    "TicketGo";
            body = body.replace("{{userName}}", userName);
            body = body.replace("{{movieName}}", movieName);

            emailService.sendEmail(to, subject, body);
            log.info("email:{}",to);
            log.info("email sent successfully");
        }


    }
}
