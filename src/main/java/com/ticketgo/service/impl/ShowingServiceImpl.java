package com.ticketgo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.Showing;
import com.ticketgo.mapper.ShowingMapper;
import com.ticketgo.service.MovieService;
import com.ticketgo.service.ShowingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Service
@Slf4j
public class ShowingServiceImpl extends ServiceImpl<ShowingMapper, Showing> implements ShowingService {

    @Autowired
    private MovieService movieService;


    /**
     * 判断当前时间段是否存在场次
     */

    @Override
    public boolean ifExist(Showing givenShowing) {

        //1. 所给场次的开始时间和结束时间
        LocalDateTime givenStartTime = givenShowing.getStartTime();
        LocalDateTime givenEndTime = givenShowing.getEndtTime();

        //2. 获取所有showing的开始时间和结束时间
        List<Showing> list = this.list();
        for(Showing showing:list){
            //如果当前场次处于未上架，则退出循环继续查找
            if(!showing.getIsReleased()){
                continue;
            }
            log.info("场次：{}",showing);

            //当前场次处于上架，开始比对时间
            //获取开始时间
            LocalDateTime startTime = showing.getStartTime();
            LocalDateTime endTime = showing.getEndtTime();

            //3. 比对所给showing,和所有showing。
            if(givenStartTime.equals(startTime)){
                return true;
            }
            if (givenStartTime.isAfter(startTime) && givenStartTime.isBefore(endTime)) {
                return true;
            }
            //如果在时间段内有场次，则返回true
            if (givenEndTime.isAfter(startTime) && givenEndTime.isBefore(endTime)) {
                return true;
            }

        }
        return false;
    }

    /**
     * movieId->查找showing
     * @param movieId
     * @return
     */
    @Override
    public List<Showing> getShowingByMovieId(Integer movieId) {

        //条件构造器
        LambdaQueryWrapper<Showing> queryWrapper = new LambdaQueryWrapper<>();

        //movieId->查找showing
        queryWrapper.eq(Showing::getMovieId, movieId);

        List<Showing> list = this.list(queryWrapper);


        return list;
    }

    @Override
    public void setEndTime(Showing showing) {
        Movie movie = movieService.getById(showing.getMovieId());
        Integer duration = movie.getDuration();
        showing.setEndTime(showing.getStartTime().plusMinutes(duration));
    }
}
