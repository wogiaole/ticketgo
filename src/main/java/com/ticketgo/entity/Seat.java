package com.ticketgo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2023-11-05
 */
public class Seat extends Model<Seat> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "seat_id", type = IdType.AUTO)
    private Long seatId;

    private Long showingId;

    private Integer rowIndex;

    private Integer colIndex;

    private Integer status;


    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getShowingId() {
        return showingId;
    }

    public void setShowingId(Long showingId) {
        this.showingId = showingId;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getColIndex() {
        return colIndex;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Seat{" +
        "seatId=" + seatId +
        ", showingId=" + showingId +
        ", rowIndex=" + rowIndex +
        ", colIndex=" + colIndex +
        ", status=" + status +
        "}";
    }
}
