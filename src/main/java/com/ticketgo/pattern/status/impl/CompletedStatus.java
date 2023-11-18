package com.ticketgo.pattern.status.impl;

import com.ticketgo.common.Result;
import com.ticketgo.pattern.status.Status;

public class CompletedStatus extends Status {
    @Override
    public Result<String> pay() {

        return Result.error("The ticket has been completed and cannot be paid");
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
