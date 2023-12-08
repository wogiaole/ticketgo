package com.ticketgo.pattern.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieSubjectTest {
    @Test
    void notifyObserver() {
        // 创建MovieSubject对象
        MovieSubject movieSubject = new MovieSubject();

        // 创建两个Observer的模拟对象
        Observer observerMock1 = mock(Observer.class);
        Observer observerMock2 = mock(Observer.class);

        // 将Observer添加到列表中
        movieSubject.addObserver(observerMock1);
        movieSubject.addObserver(observerMock2);

        // 调用notifyObserver方法，通知所有Observer
        String movieName = "The New Blockbuster";
        movieSubject.notifyObserver(movieName);

        // 验证Observer的update方法是否被正确调用
        verify(observerMock1, times(1)).update(movieName);
        verify(observerMock2, times(1)).update(movieName);
    }
}