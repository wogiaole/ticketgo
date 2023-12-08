package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.service.TicketService;
import com.ticketgo.util.common.Result;
import com.ticketgo.entity.User;
import com.ticketgo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/* Checked out several functions
and constructors to make it more
 in line with the principle of single responsibility */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    private boolean isPasswordValid(User user, User userResult) {
        return userResult.getPassword().equals(user.getPassword());
    }
    private void setUserIdInSession(HttpServletRequest request, Long userId) {
        request.getSession().setAttribute("userId", userId);
    }

    private void clearUserIdInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
    }
    private boolean doesUserNameExist(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, user);
        return userService.getOne(queryWrapper) != null;
    }
    /**
     * 注册
     */
    @PostMapping("/register")
    @Operation(description = "用户注册")
    public Result<String> register(@RequestBody User user){
        //如果用户名存在
        if(!doesUserNameExist(user)){
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
        validateLoginParameters(user);
        //name查询数据库->得到admResult对象
        // 查询数据库获取用户信息
        User userResult = getUserFromDatabase(user.getUserName());
        // 处理登录逻辑
        return processLogin(request, user, userResult);
    }

    private User getUserFromDatabase(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        return userService.getOne(queryWrapper);
    }

    private Result<User> processLogin(HttpServletRequest request, User user, User userResult) {
        if (userResult == null) {
            return Result.error("User not found");
        }

        if (!isPasswordValid(user, userResult)) {
            return Result.error("Invalid password");
        }

        setUserIdInSession(request, userResult.getUserId());
        return Result.success(userResult);
    }

    private void validateLoginParameters(User user) {
        Assert.notNull(user, "User must not be null");
        Assert.hasText(user.getUserName(), "Username must not be empty");
        Assert.hasText(user.getPassword(), "Password must not be empty");
    }

    /**
     * 登出
     * 1. 清理session
     * 2. 返回结果
     */
    @PostMapping("/logout")
    @Operation(description = "用户登出")
    public Result<String> logout(HttpServletRequest request){
        clearUserIdInSession(request);
        return Result.success("退出成功");
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

