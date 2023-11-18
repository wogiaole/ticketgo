package com.ticketgo.controller;


import com.ticketgo.common.Result;
import com.ticketgo.entity.Ticket;
import com.ticketgo.service.SeatService;
import com.ticketgo.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.ticketgo.constant.TicketStatusConstant.UNPAID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;
    /**
     * 新增ticket
     * @return
     */
    @PostMapping("/addTicket")
    @Operation(description = "订票")
    public Result<String> save(@RequestBody Ticket ticket){

        log.info("{}",ticket);

        ticket.setStatus(UNPAID);

        return ticketService.bookTicket(ticket);
    }

    @PostMapping("/pay")
    @Operation(description = "支付")
    public Result<String> pay(@RequestBody Ticket ticket){

        //支付

        return ticketService.pay(ticket.getTicketId());
    }

    @PostMapping("/validate")
    @Operation(description = "验票")
    public Result<String> validate(@RequestBody Ticket ticket, HttpServletRequest request){
        Long adminId = (Long)request.getSession().getAttribute("adminId");//1
        // log.info("打印DTO{}",ticketDTO);

        return ticketService.validate(ticket.getTicketId(),adminId);
    }

    @PostMapping("/cancel")
    @Operation(description = "取消票")
    public Result<String> cancel(@RequestBody Ticket ticket){

        // log.info("打印DTO{}",ticketDTO);


        return ticketService.cancel(ticket.getTicketId());
    }

    /*@GetMapping("/sendEmail")
    public Result<String> sendEmail() {
        String to = "lftang1007@gmail.com"; // 接收者的邮箱地址
        String subject = "hello";
        String body = "test";

        emailService.sendEmail(to, subject, body);
        return Result.success("发送成功");
    }*/




}

