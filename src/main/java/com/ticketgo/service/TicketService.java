package com.ticketgo.service;

import com.ticketgo.util.common.Result;
import com.ticketgo.entity.Ticket;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
public interface TicketService extends IService<Ticket> {
    //public void save(TicketDTO ticketDTO);

    //public void pay(TicketDTO ticketDTO);

    public Result<String> pay(Ticket ticket);
    public Result<String> validate(Long ticketId, Long adminId);
    public Result<String> cancel(Long ticketId);

    public Result<String> bookTicket(Ticket ticket);

}
