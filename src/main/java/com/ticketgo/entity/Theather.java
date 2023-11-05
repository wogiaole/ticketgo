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
public class Theather extends Model<Theather> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "theather_id", type = IdType.AUTO)
    private Long theatherId;

    private String theatherName;

    private Integer row;

    private Integer col;

    private Boolean isDeleted;


    public Long getTheatherId() {
        return theatherId;
    }

    public void setTheatherId(Long theatherId) {
        this.theatherId = theatherId;
    }

    public String getTheatherName() {
        return theatherName;
    }

    public void setTheatherName(String theatherName) {
        this.theatherName = theatherName;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    @Override
    public String toString() {
        return "Theather{" +
        "theatherId=" + theatherId +
        ", theatherName=" + theatherName +
        ", row=" + row +
        ", col=" + col +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
