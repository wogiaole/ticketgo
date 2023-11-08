package com.ticketgo.service.status.impl;

import com.ticketgo.common.Result;
import com.ticketgo.service.status.Status;

public class CanceledStatus extends Status {


    @Override
    public Result<String> pay() {

        return Result.error("票已取消，无法支付");
    }

    @Override
    public Result<String> cancel() {

        return Result.error("票已取消，请刷新重试");


    }

    @Override
    public Result<String> validate() {

        return Result.error("票已取消，请刷新重试");
    }
}
