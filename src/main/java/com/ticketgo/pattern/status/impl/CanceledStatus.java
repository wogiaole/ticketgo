package com.ticketgo.pattern.status.impl;

import com.ticketgo.entity.Ticket;
import com.ticketgo.util.common.Result;
import com.ticketgo.pattern.status.Status;

public class CanceledStatus extends Status {


    @Override
    public Result<String> pay(Ticket ticket,Integer payMethod) {

        return Result.error("Ticket has been canceled and cannot pay");
    }

    @Override
    public Result<String> cancel() {

        return Result.error("Ticket has been cancelled, please refresh and try again");


    }

    @Override
    public Result<String> validate() {

        return Result.error("Ticket has been cancelled, please refresh and try again");
    }
}
