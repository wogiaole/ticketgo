package com.ticketgo.pattern.observer;

import com.ticketgo.service.impl.EmailService;
import org.junit.jupiter.api.Test;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmailObserverTest {
    @Test
    void update() {
        // 创建EmailService的模拟对象
        EmailService emailServiceMock = mock(EmailService.class);

        // 创建EmailObserver对象，传入模拟的EmailService、电子邮件地址和用户名
        String userEmail = "23228989@studentmail.ul.ie";
        String userName = "zhi zheng";
        EmailObserver emailObserver = new EmailObserver(emailServiceMock, userEmail, userName);

        // 调用update方法，传入电影名称
        String movieName = "The New Blockbuster";
        emailObserver.update(movieName);

        // 验证sendEmail方法是否被正确调用，且传递了正确的参数
        verify(emailServiceMock,times(1)).sendEmail(String.valueOf(emailObserver),"New Movie released!",contains(movieName));
    }
}