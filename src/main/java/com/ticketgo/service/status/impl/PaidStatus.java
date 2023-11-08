package com.ticketgo.service.status.impl;

import com.ticketgo.common.Result;
import com.ticketgo.service.status.Status;

import java.time.LocalDateTime;

import static com.ticketgo.constant.TicketStatusConstant.COMPLETED;

public class PaidStatus extends Status {


    @Override
    public Result<String> pay() {
        return Result.error("已支付，请刷新重试！");
    }

    @Override
    public Result<String> cancel() {

        return Result.error("已支付，无法取消");
    }

    @Override
    public Result<String> validate() {
        super.ticket.setStatus(COMPLETED);
        super.ticket.setValidateTime(LocalDateTime.now());

        return Result.success("验票成功");
    }
}
