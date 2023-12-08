package com.ticketgo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.entity.Movie;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ticketgo.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    MovieMapper movieMapper = null;

    public default Page<Movie> getPage(int page, int pageSize) {
        Page<Movie> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();
        // 添加排序条件（按电影创建时间）
        queryWrapper.orderByAsc(Movie::getCreateTime);
        this.page(pageInfo, queryWrapper);
        return pageInfo;
    }
}
