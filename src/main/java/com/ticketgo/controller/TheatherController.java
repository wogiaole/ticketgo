package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.common.Result;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.Theather;
import com.ticketgo.service.TheatherService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

@RestController
@RequestMapping("/theather")
@Slf4j
public class TheatherController {
    @Autowired
    private TheatherService theatherService;

    /**
     * 新增放映厅
     * @param theather
     * @return
     */
    @PostMapping("/addTheater")
    @Operation(description = "新增放映厅")
    public Result<String> save(@RequestBody Theather theather){
        log.info("新增电影 info: "+theather);
        theather.setIsDeleted(false);
        theatherService.save(theather);
        return Result.success("add theater successfully");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "放映厅的分页显示")
    public Result<Page> page(int page, int pageSize){ //页数、每页展示n条
        log.info("页数页码",page,pageSize);
        //分页构造器
        Page<Theather> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Theather> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件（按影院id）
        queryWrapper.orderByAsc(Theather::getTheatherId);

        theatherService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }

    /**
     * 查询影院
     */
    @GetMapping("/list")
    @Operation(description = "基于名称，模糊查询放映厅")
    public Result<List<Theather>> list(String theaterName){
        LambdaQueryWrapper<Theather> queryWrapper = new LambdaQueryWrapper<>();

        //按影院名模糊查询
        if(theaterName!=""){//如果输入的影院名不为空
            queryWrapper.like(Theather::getTheatherName,theaterName);
        }

        //按id正序
        queryWrapper.orderByAsc(Theather::getTheatherId);
        List<Theather> list = theatherService.list(queryWrapper);
        return Result.success(list);
    }

    /**
     * 修改theater信息
     */
    @PutMapping
    @Operation(description = "修改放映厅")
    public Result<String> updateUser(@RequestBody Theather theather){
        log.info("修改影院信息{}",theather);
        theatherService.updateById(theather);
        return Result.success("theater modify successfully");
    }


}

