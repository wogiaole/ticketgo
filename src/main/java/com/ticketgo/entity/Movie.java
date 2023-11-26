package com.ticketgo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ticketgo.pattern.composite.MovieComponent;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2023-11-05
 */

@NoArgsConstructor
public class Movie extends Model<Movie> implements MovieComponent  {

    private static final long serialVersionUID = 1L;

      @TableId(value = "movie_id", type = IdType.AUTO)
    private Long movieId;

    private String movieName;

    private String genre;

    private Integer duration;

    private String country;

    private String director;

    private String actor;

    private String picture;

    private String detail;

    private LocalDate pulishDate;

    private LocalDateTime createTime;

    private Boolean isReleased;


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(LocalDate pulishDate) {
        this.pulishDate = pulishDate;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Boolean isReleased) {
        this.isReleased = isReleased;
    }


    @Override
    public String toString() {
        return "Movie{" +
        "movieId=" + movieId +
        ", movieName=" + movieName +
        ", genre=" + genre +
        ", duration=" + duration +
        ", country=" + country +
        ", director=" + director +
        ", actor=" + actor +
        ", picture=" + picture +
        ", detail=" + detail +
        ", pulishDate=" + pulishDate +
        ", createTime=" + createTime +
        ", isReleased=" + isReleased +
        "}";
    }

    @Override
    public void displayInfo() {

    }

}
