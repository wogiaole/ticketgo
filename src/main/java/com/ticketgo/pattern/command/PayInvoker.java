package com.ticketgo.pattern.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayInvoker {

    private PayCommand payCommand;


    //set command base on payment method
    public void setPayCommand(Integer paymethod) {
        if (paymethod.equals(1)) {
            this.payCommand = new CreditcardCommand();
        } else if (paymethod.equals(2)) {
            this.payCommand = new PaypalCommand();
        } else if (paymethod.equals(3)) {
            this.payCommand = new ApplePayCommand();

        }
    }


    public void executePayment(){
        payCommand.execute();
    }
}
