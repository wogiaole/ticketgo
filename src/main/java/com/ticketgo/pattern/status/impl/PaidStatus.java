package com.ticketgo.pattern.status.impl;

import com.ticketgo.entity.Ticket;
import com.ticketgo.util.common.Result;
import com.ticketgo.pattern.status.Status;

import java.time.LocalDateTime;

import static com.ticketgo.util.constant.TicketStatusConstant.COMPLETED;

public class PaidStatus extends Status {


    @Override
    public Result<String> pay(Ticket ticket,Integer payMethod) {
        return Result.error("Ticket has been paid and cannot be pay again");
    }

    @Override
    public Result<String> cancel() {

        return Result.error("Already paid, unable to cancel");
    }

    @Override
    public Result<String> validate() {
        super.ticket.setStatus(COMPLETED);
        super.ticket.setValidateTime(LocalDateTime.now());

        return Result.success("validate success");
    }
}
