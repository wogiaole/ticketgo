package com.ticketgo.pattern.status.impl;

import com.ticketgo.entity.Ticket;
import com.ticketgo.util.common.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ticketgo.util.constant.TicketStatusConstant.CANCELED;
import static com.ticketgo.util.constant.TicketStatusConstant.PAID;
import static org.junit.jupiter.api.Assertions.*;

class UnpaidStatusTest {
    private UnpaidStatus unpaidStatus;
    private Ticket ticket;
    @BeforeEach
    void setUp() {
        unpaidStatus = new UnpaidStatus();
        ticket = new Ticket();
        unpaidStatus.setTicket(ticket);
    }
    @Test
    void pay() {
        Result<String> result = unpaidStatus.pay(ticket, 1);
        assertEquals("pay success", result.getData());
        assertEquals(PAID, ticket.getStatus());
        assertNotNull(ticket.getPayTime());
        assertEquals(1, ticket.getPayMethod());
    }

    @Test
    void cancel() {
        Result<String> result = unpaidStatus.cancel();
        assertEquals("Cancel success", result.getData());
        assertEquals(CANCELED, ticket.getStatus());
        assertNotNull(ticket.getCancelTime());
    }

    @Test
    void validate() {
        Result<String> result = unpaidStatus.validate();
        //assertEquals("Unpaid ticket cannot be verified!", result.getData());
    }
}