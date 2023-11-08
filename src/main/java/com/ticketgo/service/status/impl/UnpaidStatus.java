package com.ticketgo.service.status.impl;

import com.ticketgo.common.Result;
import com.ticketgo.service.status.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.ticketgo.constant.TicketStatusConstant.*;

@Service
@Slf4j
public class UnpaidStatus extends Status {

    @Override
    public Result<String> pay() {

        //修改票状态
        super.ticket.setStatus(PAID);
        super.ticket.setPayTime(LocalDateTime.now());

        return Result.success("支付成功");

    }

    @Override
    public Result<String> cancel() {

        //修改票状态
        super.ticket.setStatus(CANCELED);
        super.ticket.setCancelTime(LocalDateTime.now());


        return Result.success("取消成功");
    }

    @Override
    public Result<String> validate() {

        return Result.error("未支付的订单无法验票！");

    }
}
