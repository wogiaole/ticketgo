package com.ticketgo.pattern.status.impl;

import com.ticketgo.entity.Ticket;
import com.ticketgo.pattern.command.PayInvoker;
import com.ticketgo.util.common.Result;
import com.ticketgo.pattern.status.Status;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import static com.ticketgo.util.constant.TicketStatusConstant.*;


public class UnpaidStatus extends Status {

    private final PayInvoker payInvoker = new PayInvoker();

    @Override
    public Result<String> pay(Ticket ticket,Integer payMethod) {

        //调用支付命令
        payInvoker.setPayCommand(payMethod);
        payInvoker.executePayment();

        //修改票状态
        super.ticket.setStatus(PAID);
        super.ticket.setPayTime(LocalDateTime.now());
        super.ticket.setPayMethod(payMethod);

        return Result.success("pay success");

    }

    @Override
    public Result<String> cancel(Ticket ticket) {
        return null;
    }

    @Override
    public Result<String> validate(Ticket ticket) {
        return null;
    }

    @Override
    public Result<String> cancel() {

        //修改票状态
        super.ticket.setStatus(CANCELED);
        super.ticket.setCancelTime(LocalDateTime.now());


        return Result.success("Cancel success");
    }

    @Override
    public Result<String> validate() {
        return Result.error("Unpaid ticket cannot be verified!");
    }
}
