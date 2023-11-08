package com.ticketgo.service;

import com.ticketgo.entity.Movie;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
public interface MovieService extends IService<Movie> {

    public int getDuration(double movieId);
    public boolean save(Movie movie);

}
