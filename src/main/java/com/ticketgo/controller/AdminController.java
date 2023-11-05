package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.common.Result;
import com.ticketgo.entity.Admin;
import com.ticketgo.entity.User;
import com.ticketgo.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
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

@Slf4j
@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 登录
     * @param request
     * @param admin
     * @return
     */

    @PostMapping("/login")
    @Operation(description = "admin登录")

    //RequestBody：接受前端对象，封装成admin对象
    //httpservletrequest:将admin对象的id存入session，用于登陆后获取当前对象
    public Result<Admin> login(HttpServletRequest request, @RequestBody Admin admin){
        //1. name查询数据库->得到admResult对象
        LambdaQueryWrapper<Admin> qw = new LambdaQueryWrapper<>();
        qw.eq(Admin::getAdminName,admin.getAdminName());
        Admin admResult = adminService.getOne(qw);

        //2.查询失败，返回错误结果
        if(admResult==null){
            return Result.error("查询不到用户名");//如果查询为空，登录失败
        }
        //3.查询成功，比对密码
        if(!admResult.getPassword().equals(admin.getPassword())){
            return Result.error("密码错误");//4.比对失败，返回错误结果

            }else{//5.比对成功，将员工id存入session+返回成功结果
                request.getSession().setAttribute("admin",admResult.getAdminId());
                return Result.success(admResult);
            }
        }

    /**
     * 登出
     * 1. 清理session
     * 2. 返回结果
     */
    @PostMapping("/logout")
    @Operation(description = "admin登出")

    public Result<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");//1
        return Result.success("退出成功");//2
    }




    /**
     * 新增admin
     */
    @PostMapping("/addAdmin")
    @Operation(description = "新增admin")

    public Result<String> save(@RequestBody Admin admin){

        LambdaQueryWrapper<Admin> qw = new LambdaQueryWrapper<>();
        qw.eq(Admin::getAdminName,admin.getAdminName());
        Admin admResult = adminService.getOne(qw);

        //如果name存在
        if(admResult!=null){
            return Result.error("name already exists");
        }
        //如果不存在，新增admin成功
        admin.setPassword("123");
        admin.setCreateTime(LocalDateTime.now());
        log.info("新增员工：{}",admin.toString());
        adminService.save(admin);

        return Result.success("add admin successfully");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "admin信息分页查询")

    public Result<Page> page(int page, int pageSize){ //页数、每页展示n条
        log.info("页数页码",page,pageSize);
        //分页构造器
        Page<Admin> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        //创建时间倒叙查看
        queryWrapper.orderByDesc(Admin::getCreateTime);

        adminService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }


    /**
     * 修改admin信息
     */
    @PutMapping
    @Operation(description = "修改admin")
    public Result<String> updateUser(@RequestBody Admin admin){
        log.info("修改用户信息{}",admin);
        adminService.updateById(admin);
        return Result.success("admin modify successfully");
    }



}

