package com.ticketgo.pattern.observer;

import com.ticketgo.service.impl.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
* New EmailObserber function, MoiveSubject focuses on
*  observation,
* the specific email notification logic can be implemented by the observer*/
@Service
@Slf4j
public class MovieSubject implements Subject {

    @Autowired
    private EmailService emailService;
    private final List<Observer> userList = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void notifyObserver(String movieName) {
        for (Observer user : userList) {
            user.update(movieName);
        }
    }
}
