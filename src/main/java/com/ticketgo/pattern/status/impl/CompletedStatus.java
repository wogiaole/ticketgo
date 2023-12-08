package com.ticketgo.pattern.status.impl;

import com.ticketgo.entity.Ticket;
import com.ticketgo.util.common.Result;
import com.ticketgo.pattern.status.Status;

public class CompletedStatus extends Status{
    @Override
    public Result<String> pay(Ticket ticket,Integer payMethod) {

        return Result.error("The ticket has been completed and cannot be paid");
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

        return Result.error("The ticket has been completed and cannot be canceled");

    }

    @Override
    public Result<String> validate() {

        return Result.error("The ticket has been completed and cannot be verified");

    }
}
