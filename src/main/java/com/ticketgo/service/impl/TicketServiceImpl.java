package com.ticketgo.service.impl;

import com.ticketgo.common.Result;
import com.ticketgo.decorator.BirthdayDecorator;
import com.ticketgo.decorator.ChristmasDecorator;
import com.ticketgo.entity.*;
import com.ticketgo.mapper.StatusMapper;
import com.ticketgo.mapper.TicketMapper;
import com.ticketgo.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ticketgo.service.util.PriceCalculateService;
import com.ticketgo.strategy.PriceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ticketgo.constant.SeatStatusConstant.AVAILABLE;
import static com.ticketgo.constant.TicketStatusConstant.UNPAID;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Service
@Slf4j
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket> implements TicketService {

    @Autowired
    private SeatService seatService;

    @Autowired
    private PriceCalculateService priceCalculateService;

    @Override
    public Result<String> pay(Long ticketId) {

        Ticket ticket = this.getById(ticketId);
        log.info("票={}",ticket);

        //1. change ticket status
        //状态模式-实现pay
        Integer status = ticket.getStatus();
        log.info("当前票的状态为{}",status);
        //为ticket设置新数据
        ticket.setTicketStatus(StatusMapper.mapIntToStatus(status));
        Result<String> r = ticket.pay();

        //如果已支付
        if(r.getCode()==1){
            //更新票状态
            this.updateById(ticket);
            //更新座位状态
            seatService.soldSeat(ticket.getSeatId());
        }

        //返回消息
        return r;

    }

    @Override
    public Result<String> validate(Long ticketId,Long adminId) {

        Ticket ticket = this.getById(ticketId);
        Integer status = ticket.getStatus();
        log.info("当前票的状态为{}",status);
        //为ticket设置新数据
        ticket.setTicketStatus(StatusMapper.mapIntToStatus(status));
        ticket.setValidateAdminId(adminId);

        Result<String> r = ticket.validate();

        //如果已验票
        if(r.getCode()==1){
            //更新票状态
            this.updateById(ticket);
        }

        //返回消息
        return r;

    }

    @Override
    public Result<String> cancel(Long ticketId) {
        Ticket ticket = this.getById(ticketId);


        //1.change ticket status
        Integer status = ticket.getStatus();
        log.info("当前票的状态为{}",status);
        //为ticket设置新数据
        ticket.setTicketStatus(StatusMapper.mapIntToStatus(status));
        Result<String> r = ticket.cancel();
        //如果已取消
        if(r.getCode()==1){
            //更新票状态
            this.updateById(ticket);
            //更新座位状态
            seatService.releaseSeat(ticket.getSeatId());
        }

        //返回消息
        return r;
    }

    @Override
    public Result<String> bookTicket(Ticket ticket) {
        Seat seat = seatService.getById(ticket.getSeatId());
        if(seat.getStatus()!=AVAILABLE){
            return Result.error("座位已被选，请重新选择");
        }else{
            //1. add ticket

            BigDecimal cost = priceCalculateService.calculatePrice(ticket);

            //将价格更新到ticket中
            ticket.setPrice(cost);

            log.info("最终价格为{}",cost);
            //设置票信息
            ticket.setStatus(UNPAID);
            ticket.setCreateTime(LocalDateTime.now());
            super.save(ticket);

            //2. change seat status
            seatService.bookSeat(ticket.getSeatId());
            return Result.success("订票成功");
        }

    }

}
