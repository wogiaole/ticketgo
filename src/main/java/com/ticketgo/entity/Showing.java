package com.ticketgo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Showing extends Model<Showing> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "showing_id", type = IdType.AUTO)
    private Long showingId;

    private Long movieId;

    private Long theatherId;

    private BigDecimal price;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Boolean isReleased;


    public Long getShowingId() {
        return showingId;
    }

    public void setShowingId(Long showingId) {
        this.showingId = showingId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheatherId() {
        return theatherId;
    }

    public void setTheatherId(Long theatherId) {
        this.theatherId = theatherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndtTime() {
        return endTime;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public Boolean getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Boolean isReleased) {
        this.isReleased = isReleased;
    }


    @Override
    public String toString() {
        return "Showing{" +
        "showingId=" + showingId +
        ", movieId=" + movieId +
        ", theatherId=" + theatherId +
        ", price=" + price +
        ", startTime=" + startTime +
                ", endTime=" + endTime +
        ", isReleased=" + isReleased +
        "}";
    }
}
