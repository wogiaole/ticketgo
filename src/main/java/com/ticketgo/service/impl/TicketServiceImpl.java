package com.ticketgo.service.impl;

import com.ticketgo.common.Result;
import com.ticketgo.entity.*;
import com.ticketgo.mapper.StatusMapper;
import com.ticketgo.mapper.TicketMapper;
import com.ticketgo.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        log.info("ticket info={}",ticket);

        //state pattern
        Integer status = ticket.getStatus();
        log.info("The current ticket status is{}",status);
        //setTicketStatus base on mapping
        ticket.setTicketStatus(StatusMapper.mapIntToStatus(status));
        Result<String> r = ticket.pay();

        //if pay success
        if(r.getCode()==1){
            //update ticket status
            this.updateById(ticket);
            //update seat status
            seatService.soldSeat(ticket.getSeatId());
        }

        //返回消息
        return r;

    }

    @Override
    public Result<String> validate(Long ticketId,Long adminId) {

        Ticket ticket = this.getById(ticketId);
        Integer status = ticket.getStatus();
        log.info("The current ticket status is{}",status);

        //set Status base on mapping
        ticket.setTicketStatus(StatusMapper.mapIntToStatus(status));
        ticket.setValidateAdminId(adminId);

        Result<String> r = ticket.validate();

        //if validate success
        if(r.getCode()==1){
            //update status
            this.updateById(ticket);
        }

        //return message
        return r;

    }

    @Override
    public Result<String> cancel(Long ticketId) {
        Ticket ticket = this.getById(ticketId);


        //1.change ticket status
        Integer status = ticket.getStatus();
        log.info("The current ticket status is{}",status);

        ticket.setTicketStatus(StatusMapper.mapIntToStatus(status));
        Result<String> r = ticket.cancel();

        //if cancel success
        if(r.getCode()==1){
            //update ticket status
            this.updateById(ticket);
            //update seat status
            seatService.releaseSeat(ticket.getSeatId());
        }

        return r;
    }

    @Override
    public Result<String> bookTicket(Ticket ticket) {
        Seat seat = seatService.getById(ticket.getSeatId());
        if(seat.getStatus()!=AVAILABLE){
            return Result.error("Seat has been selected, please select again!");
        }else{
            //1. add ticket

            BigDecimal cost = priceCalculateService.calculatePrice(ticket);

            //set final price
            ticket.setPrice(cost);
            log.info("The final price is{}",cost);

            //set ticket info
            ticket.setStatus(UNPAID);
            ticket.setCreateTime(LocalDateTime.now());
            super.save(ticket);

            //2. change seat status
            seatService.bookSeat(ticket.getSeatId());
            return Result.success("Booking successful");
        }

    }

}
