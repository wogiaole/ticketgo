package com.ticketgo.service;

import com.ticketgo.entity.Showing;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
public interface ShowingService extends IService<Showing> {
    //当前是否存在场次
    public boolean ifExist(Showing showing);

    //基于电影id，查场次
    public List<Showing> getShowingByMovieId(Integer movieId);

    //为showing设置endTime
    public void setEndTime(Showing showing);


}
