package com.ticketgo.service.status.impl;

import com.ticketgo.common.Result;
import com.ticketgo.service.status.Status;

public class CompletedStatus extends Status {
    @Override
    public Result<String> pay() {

        return Result.error("票已完成，无法支付");
    }

    @Override
    public Result<String> cancel() {

        return Result.error("票已完成，无法取消");

    }

    @Override
    public Result<String> validate() {

        return Result.error("票已完成，无法再验票");

    }
}
