package com.ticketgo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ticketgo.common.Result;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.Showing;
import com.ticketgo.entity.Theather;
import com.ticketgo.mapper.MovieMapper;
import com.ticketgo.service.MovieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ticketgo.service.TheatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Autowired
    MovieMapper movieMapper;

    //基于电影id，查找duration

    @Override
    public int getDuration(double movieId) {
        //条件构造器
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();

        //基于Id,查找Movie
        queryWrapper.eq(Movie::getMovieId, movieId);

        Movie movie = this.getOne(queryWrapper);

        //查找duration
        if (movie != null) {
            return movie.getDuration();
        } else {
            return 0;
        }
    }
}
