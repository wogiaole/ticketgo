package com.ticketgo.controller;


import com.ticketgo.util.common.Result;
import com.ticketgo.entity.Seat;
import com.ticketgo.entity.Showing;
import com.ticketgo.service.SeatService;
import com.ticketgo.service.ShowingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/showing")
@Slf4j
public class ShowingController {
    @Autowired
    private ShowingService showingService;

    @Autowired
    private SeatService seatService;

    /**
     * 新增场次
     */
    @PostMapping("/addShowing")
    @Operation(description = "新增场次")
    public Result<String> save(@RequestBody Showing showing){

        //1. set endTime
        showingService.setEndTime(showing);

        //2. 判断当前是否存在场次
        boolean exist = showingService.ifExist(showing);

        //3. 如果时间段已安排场次，则报错
        if(exist){
            return Result.error("The current time slot has existing showtimes.");
        }

        //4. 若没安排，则新增场次
        log.info("新增场次: "+showing);
        showingService.save(showing);

        //基于场次生成座位
        seatService.generateSeat(showing);
        return Result.success("add showing successfully");
    }

    /**
     * 修改showing信息（修改+上下架共用这个接口）
     */
    @PutMapping
    @Operation(description = "修改场次信息，修改+上下架共用这个接口")
    public Result<String> updateUser(@RequestBody Showing showing){
        //1. 判断当前是否存在场次
        boolean exist = showingService.ifExist(showing);
        //2. 如果时间段已安排场次，则报错
        if(exist){
            return Result.error("The current time slot has existing showtimes.");
        }
        //3. 若不存在场次，则继续修改
        log.info("修改影院信息{}",showing);
        showingService.updateById(showing);
        return Result.success("modify showing successfully");
    }

    /**
     * 场次详情（选座图）
     */
    @GetMapping("/seats")
    @Operation(description = "查看场次的座位")
    public Result<List<Seat>> seats(Integer showingId){

        List<Seat> seats = seatService.getSeatByShowingId(showingId);

        return Result.success(seats);

    }


}

