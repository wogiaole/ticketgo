package com.ticketgo.pattern.status;

import com.ticketgo.util.common.Result;
import com.ticketgo.entity.Ticket;

public abstract class Status {
    protected Ticket ticket;

    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    };
    public abstract Result<String> pay();
    public abstract Result<String> cancel();
    public abstract Result<String> validate();
}