package com.ticketgo.pattern.command;

import org.springframework.stereotype.Component;


public class ApplePayCommand implements PayCommand{
    private PayReciver payReciver = new PayReciver();
    @Override
    public void execute() {
        payReciver.applePay();
    }

}
