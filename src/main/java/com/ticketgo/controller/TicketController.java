package com.ticketgo.controller;


import com.ticketgo.service.TheatherService;
import com.ticketgo.util.common.Result;
import com.ticketgo.entity.Ticket;
import com.ticketgo.service.SeatService;
import com.ticketgo.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.ticketgo.util.constant.TicketStatusConstant.UNPAID;
@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {
    /*
    Inject theater Service via constructor
    * */
    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/addTicket")
    @Operation(description = "book ticket")
    public Result<String> save(@RequestBody Ticket ticket){

        ticket.setStatus(UNPAID);

        return ticketService.bookTicket(ticket);
    }

    @PostMapping("/pay")
    @Operation(description = "pay")
    public Result<String> pay(@RequestBody Ticket ticket){

       return ticketService.pay(ticket);
    }

    @PostMapping("/validate")
    @Operation(description = "验票")
    public Result<String> validate(@RequestBody Ticket ticket, HttpServletRequest request){
        Long adminId = (Long)request.getSession().getAttribute("adminId");

        return ticketService.validate(ticket.getTicketId(),adminId);
    }

    @PostMapping("/cancel")
    @Operation(description = "取消票")
    public Result<String> cancel(@RequestBody Ticket ticket){
        return ticketService.cancel(ticket.getTicketId());
    }
}

