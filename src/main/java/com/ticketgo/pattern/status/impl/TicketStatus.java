package com.ticketgo.pattern.status.impl;

import com.ticketgo.entity.Ticket;
import com.ticketgo.util.common.Result;

/*
* New abstract interface to satisfy the Richter substitution principle
* */
public interface TicketStatus {
    Result<String> pay(Ticket ticket, Integer payMethod);
    Result<String> cancel(Ticket ticket);
    Result<String> validate(Ticket ticket);
}
