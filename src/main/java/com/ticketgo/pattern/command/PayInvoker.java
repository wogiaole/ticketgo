package com.ticketgo.pattern.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayInvoker {

    private PayCommand payCommand;


    //set command base on payment method
    public void setPayCommand(Integer payMethod) {
        switch (payMethod) {
            case 1:
                this.payCommand = new CreditcardCommand();
                break;
            case 2:
                this.payCommand = new PaypalCommand();
                break;
            case 3:
                this.payCommand = new ApplePayCommand();
                break;
            default:
                log.warn("Unknown payment method: {}", payMethod);
                // 抛出 IllegalArgumentException，说明参数非法
                throw new IllegalArgumentException("Unknown payment method: " + payMethod);
        }
    }
    public void executePayment() {
        if (payCommand == null) {
            // 如果未设置支付命令，抛出 IllegalStateException，说明状态异常
            throw new IllegalStateException("Pay command not set");
        }
        payCommand.execute();
    }
}
