package com.ticketgo.pattern.status.impl;

import com.ticketgo.common.Result;
import com.ticketgo.pattern.status.Status;

import java.time.LocalDateTime;

import static com.ticketgo.constant.TicketStatusConstant.COMPLETED;

public class PaidStatus extends Status {


    @Override
    public Result<String> pay() {
        return Result.error("Has paid, please refresh and try again!");
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
