package com.ticketgo.service.impl;

import com.ticketgo.entity.Admin;
import com.ticketgo.mapper.AdminMapper;
import com.ticketgo.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
