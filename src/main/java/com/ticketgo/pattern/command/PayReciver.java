package com.ticketgo.pattern.command;

import org.springframework.stereotype.Component;

public class PayReciver {
    public void creditCardPay(){
        System.out.println("Call the credit card payment interface...");
    }

    public void paypalPay(){
        System.out.println("Call the PayPal payment interface...");
    }

    public void applePay(){
        System.out.println("Call the Apple payment interface...");
    }


}
