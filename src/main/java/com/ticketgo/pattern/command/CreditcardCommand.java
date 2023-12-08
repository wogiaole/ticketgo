package com.ticketgo.pattern.command;

import org.springframework.stereotype.Component;


public class CreditcardCommand implements PayCommand{

    private final PayReciver payReciver = new PayReciver();

    @Override
    public void execute() {
        payReciver.creditCardPay();
    }
}
