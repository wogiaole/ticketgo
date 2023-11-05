package com.ticketgo.mapper;

import com.ticketgo.entity.Ticket;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Mapper
public interface TicketMapper extends BaseMapper<Ticket> {

}