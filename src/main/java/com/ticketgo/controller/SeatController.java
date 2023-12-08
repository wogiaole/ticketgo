package com.ticketgo.controller;


import com.ticketgo.entity.Seat;
import com.ticketgo.service.SeatService;
import com.ticketgo.util.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@RestController
@RequestMapping("/seat")
@Slf4j
public class SeatController {
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{showingId}/seats")
    @Operation(description = "查看场次的座位")
    public Result<List<Seat>> getShowingSeats(@PathVariable Integer showingId) {
        Assert.notNull(showingId, "Showing ID must not be null");
        List<Seat> seats = seatService.getSeatByShowingId(showingId);
        return Result.success(seats);
    }
}

