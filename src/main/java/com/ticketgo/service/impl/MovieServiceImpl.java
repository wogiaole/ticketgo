package com.ticketgo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.User;
import com.ticketgo.mapper.MovieMapper;
import com.ticketgo.service.MovieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ticketgo.service.UserService;
import com.ticketgo.service.observer.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
@Slf4j
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Autowired
    private UserService userService;

    @Autowired
   private Subject movieSubject;


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

    @Override
    public boolean save(Movie movie) {
        //新增电影
        boolean isSave = super.save(movie);

        log.info("电影状态={}",movie.getIsReleased());

        //如果电影是上架状态,则邮件通知订阅用户
        if(movie.getIsReleased()){
            //1. 查找allow_nofi =1 的用户

            //条件构造器
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

            //基于Id,查找Movie
            queryWrapper.eq(User::getAllowNofity, true);

            List<User> list = userService.list(queryWrapper);

            //2. 将observer加入subject中
            for (User user:list){
                log.info("observer={}",user.getUserName());
                movieSubject.addObserver(user);
            }
            movieSubject.notifyObserver(movie.getMovieName());
        }

        return isSave;
    }


}
