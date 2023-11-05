package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.common.Result;
import com.ticketgo.entity.Admin;
import com.ticketgo.entity.Theather;
import com.ticketgo.entity.User;
import com.ticketgo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserService userService;

    /**
     * 注册
     */
    @PostMapping("/register")
    @Operation(description = "用户注册")
    public Result<String> register(@RequestBody User user){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getUserName,user.getUserName());
        User userResult = userService.getOne(qw);

        //如果用户名存在
        if(userResult!=null){
            return Result.error("name already exists");
        }

        //为用户设置默认信息
        user.setType(1);
        user.setAllowNofity(false);
        user.setCreateTime(LocalDateTime.now());
        user.setIsDeleted(false);

        log.info("新增用户：{}",user.toString());
        userService.save(user);

        return Result.success("register successfully");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @Operation(description = "用户登录")
    //RequestBody：接受前端对象，封装成admin对象
    //httpservletrequest:将admin对象的id存入session，用于登陆后获取当前对象
    public Result<User> login(HttpServletRequest request, @RequestBody User user){
        //1. name查询数据库->得到admResult对象
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getUserName,user.getUserName());
        User userResult = userService.getOne(qw);

        //2.查询失败，返回错误结果
        if(userResult==null){
            return Result.error("查询不到用户名");//如果查询为空，登录失败
        }
        //3.查询成功，比对密码
        if(!userResult.getPassword().equals(user.getPassword())){
            return Result.error("密码错误");//4.比对失败，返回错误结果

        }else{//5.比对成功，将员工id存入session+返回成功结果
            request.getSession().setAttribute("admin",userResult.getUserId());
            return Result.success(userResult);
        }
    }

    /**
     * 登出
     * 1. 清理session
     * 2. 返回结果
     */
    @PostMapping("/logout")
    @Operation(description = "用户登出")
    public Result<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");//1
        return Result.success("退出成功");//2
    }



    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "用户信息，分页查询")
    public Result<Page> page(int page, int pageSize){ //页数、每页展示n条
        log.info("页数页码",page,pageSize);
        //分页构造器
        Page<User> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //创建时间倒叙查看
        queryWrapper.orderByDesc(User::getCreateTime);

        userService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }

    /**
     * 修改用户信息
     */
    @PutMapping
    @Operation(description = "修改单个用户信息")
    public Result<String> updateUser(@RequestBody User user){
        log.info("修改用户信息{}",user);
        userService.updateById(user);
        return Result.success("user modify successfully");
    }


}

