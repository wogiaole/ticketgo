package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.common.Result;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.Seat;
import com.ticketgo.entity.Showing;
import com.ticketgo.service.MovieService;
import com.ticketgo.service.SeatService;
import com.ticketgo.service.ShowingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
            return Result.error("当前时间段存在场次");
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
            return Result.error("当前时间段存在场次");
        }
        //3. 若不存在场次，则继续修改
        log.info("修改影院信息{}",showing);
        showingService.updateById(showing);
        return Result.success("modify showing successfully");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "showing分页查询")
    public Result<Page> page(int page, int pageSize){ //页数、每页展示n条
        log.info("页数页码",page,pageSize);
        //分页构造器
        Page<Showing> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Showing> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件（最早的排前面）
        queryWrapper.orderByAsc(Showing::getStartTime);

        showingService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }

    /**
     * 场次详情（选座图）
     */
    @GetMapping("/seats")
    @Operation(description = "查看场次座位表")
    public Result<List<Seat>> seats(Integer showingId){
        //条件构造器
        LambdaQueryWrapper<Seat> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Seat::getShowingId,showingId);

        //基于showingId，获取seats
        List<Seat> list = seatService.list(queryWrapper);

        return Result.success(list);

    }


}

