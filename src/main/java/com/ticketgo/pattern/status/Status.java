package com.ticketgo.pattern.status;

import com.ticketgo.pattern.status.impl.TicketStatus;
import com.ticketgo.util.common.Result;
import com.ticketgo.entity.Ticket;

public abstract class Status implements TicketStatus {
    protected Ticket ticket;

    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    };
    public abstract Result<String> pay(Ticket ticket,Integer payMethod);
    public abstract Result<String> cancel();
    public abstract Result<String> validate();
}