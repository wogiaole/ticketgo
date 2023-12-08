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
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// solid !
/*
The logic of paging queries is transferred to serverice,
which is more in line with the single responsibility principle.
*/
@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final ShowingService showingService;

    @Autowired
    public MovieController(MovieService movieService, ShowingService showingService) {
        this.movieService = movieService;
        this.showingService = showingService;
    }

    /**
     * 新增电影
     * @param movie
     * @return
     */
    @PostMapping("/addMovie")
    @Operation(description = "新增电影")
    public Result<String> addMovie(@RequestBody Movie movie) {
        Assert.notNull(movie, "Movie must not be null");
        movie.setCreateTime(LocalDateTime.now());
        log.info("新增电影 info: " + movie);
        movieService.save(movie);
        return Result.success("add movie successfully");
    }

    /**
     * 分页查询电影
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @Operation(description = "电影分页查询")
    public Result<Page<Movie>> page(int page, int pageSize) {
        Assert.isTrue(page > 0 && pageSize > 0, "Invalid page or pageSize");
        log.info("页数页码", page, pageSize);
        Page<Movie> pageInfo = movieService.getPage(page, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * 查询电影
     */
    @GetMapping("/list")
    @Operation(description = "输入名称，模糊搜索电影")
    public Result<List<Movie>> list(String movieName) {
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();

        if (!movieName.isEmpty()) {
            queryWrapper.like(Movie::getMovieName, movieName);
        }

        queryWrapper.orderByAsc(Movie::getMovieId);
        List<Movie> list = movieService.list(queryWrapper);
        return Result.success(list);
    }

    /**
     * 查询电影详情
     */
    @GetMapping("/detail")
    @Operation(description = "查看电影详情")
    public Result<Movie> detail(Integer movieId) {
        Assert.notNull(movieId, "Movie ID must not be null");
        Movie movie = movieService.getById(movieId);
        Assert.notNull(movie, "Movie not found for ID: " + movieId);
        return Result.success(movie);
    }

    /**
     * 查询电影的场次
     */
    @GetMapping("/showing")
    @Operation(description = "查看电影的场次")
    public Result<List<Showing>> showing(Integer movieId) {
        Assert.notNull(movieId, "Movie ID must not be null");
        List<Showing> showings = showingService.getShowingByMovieId(movieId);
        Assert.notNull(showings, "Showings not found for movie ID: " + movieId);
        return Result.success(showings);
    }

    /**
     * 修改movie信息
     */
    @PutMapping("/update")
    @Operation(description = "修改电影")
    public Result<String> updateMovie(@RequestBody Movie movie) {
        Assert.notNull(movie, "Movie must not be null");
        log.info("修改影院信息{}", movie);
        movieService.updateById(movie);
        return Result.success("movie modify successfully");
    }
}
