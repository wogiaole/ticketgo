package com.ticketgo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ticketgo.util.common.Result;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.Showing;
import com.ticketgo.service.MovieService;
import com.ticketgo.service.ShowingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/movie")

public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowingService showingService;

    /**
     * 新增电影
     * @param movie
     * @return
     */
    @PostMapping("/addMovie")
    @Operation(description = "新增电影")
    public Result<String> save(@RequestBody Movie movie){

        movie.setCreateTime(LocalDateTime.now());
        log.info("新增电影 info: "+movie);
        movieService.save(movie);
        return Result.success("add movie successfully");
    }

    /**
     * 分页查询
      * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "电影分页查询")
    public Result<Page> page(int page,int pageSize){ //页数、每页展示n条
        log.info("页数页码",page,pageSize);
        //分页构造器
        Page<Movie> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件（按电影创建时间）
        queryWrapper.orderByAsc(Movie::getCreateTime);

        movieService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }

    /**
     * 查询电影
     */
    @GetMapping("/list")
    @Operation(description = "输入名称，模糊搜索电影")
    public Result<List<Movie>> list(String movieName){
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();

        //按影院名模糊查询
        if(movieName!=""){//如果输入的影院名不为空
            queryWrapper.like(Movie::getMovieName,movieName);
        }

        //按id正序
        queryWrapper.orderByAsc(Movie::getMovieId);
        List<Movie> list = movieService.list(queryWrapper);
        return Result.success(list);
    }

    /**
     * 查询电影详情
     */
    @GetMapping("/detail")
    @Operation(description = "查看电影详情")
    public Result<Movie> list(Integer movieId){

        Movie movie = movieService.getById(movieId);

        return Result.success(movie);
    }

    /**
     * 查询电影的场次
     */
    @GetMapping("/showing")
    @Operation(description = "查看电影的场次")
    public Result<List<Showing>> showing(Integer movieId){

        List<Showing> showings = showingService.getShowingByMovieId(movieId);

        return Result.success(showings);

    }

    /**
     * 修改movie信息
     */
    @PutMapping
    @Operation(description = "修改电影")
    public Result<String> updatMovie(@RequestBody Movie movie){
        log.info("修改影院信息{}",movie);
        movieService.updateById(movie);
        return Result.success("movie modify successfully");
    }

}

