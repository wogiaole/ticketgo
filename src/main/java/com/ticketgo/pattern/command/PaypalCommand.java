package com.ticketgo.pattern.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class PaypalCommand implements PayCommand{

    private final PayReciver payReciver = new PayReciver();
    @Override
    public void execute() {
        payReciver.paypalPay();
    }
}
