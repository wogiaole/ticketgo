package com.ticketgo.pattern.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class PaypalCommand implements PayCommand{

    private PayReciver payReciver = new PayReciver();
    @Override
    public void execute() {
        payReciver.paypalPay();

    }
}
