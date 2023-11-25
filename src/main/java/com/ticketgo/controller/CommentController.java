package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.util.common.Result;
import com.ticketgo.entity.*;
import com.ticketgo.service.CommentService;
import com.ticketgo.service.SeatService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private SeatService seatService;
    /**
     * 新增评论
     * @param comment
     * @return
     */
    @PostMapping("/addComment")
    @Operation(description = "新增评论")
    public Result<String> save(@RequestBody Comment comment,HttpServletRequest request){
        //set current time
        comment.setCreateTime(LocalDateTime.now());
        //set status
        comment.setIsDeleted(false);
        //set user id
        HttpSession session = request.getSession();
        Long userId = (Long)session.getAttribute("userId");

        log.info("{}",userId);

        //Long userId = (Long)request.getSession().getAttribute("userId");
        comment.setUserId(userId);
        //save
        commentService.save(comment);
        return Result.success("add comment successfully");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/pageById")
    @Operation(description = "，基于电影，分页查询评论")
    public Result<Page> page(int page,int pageSize,long movieId){


        Page<Comment> pageInfo = new Page<>(page,pageSize);

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        //基于电影，查询评论
        queryWrapper.eq(Comment::getMovieId,movieId);
        queryWrapper.eq(Comment::getIsDeleted,false);

        //时间顺序显示评论
        queryWrapper.orderByAsc(Comment::getCreateTime);

        commentService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }



    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "评论分页查询")
    public Result<Page> page(int page,int pageSize){
        Page<Comment> pageInfo = new Page<>(page,pageSize);

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.orderByAsc(Comment::getCreateTime);

        commentService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }




    /**
     * 删除movie信息
     */
    @DeleteMapping
    @Operation(description = "删除评论")
    public Result<String> deleteComment(@RequestBody Comment comment,HttpServletRequest request){
        //set current time
        comment.setDeleteTime(LocalDateTime.now());
        //set status
        comment.setIsDeleted(true);
        //set admin id
        HttpSession session = request.getSession();
        Long adminId = (Long)session.getAttribute("adminId");

        comment.setAdminId(adminId);

        commentService.updateById(comment);
        return Result.success("delete comment successfully");
    }


}

