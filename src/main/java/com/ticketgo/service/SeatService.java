package com.ticketgo.service;

import com.ticketgo.entity.Seat;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ticketgo.entity.Showing;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
public interface SeatService extends IService<Seat> {
   public void generateSeat(Showing showing);

}
