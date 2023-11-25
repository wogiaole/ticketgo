package com.ticketgo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ticketgo.util.common.Result;
import com.ticketgo.pattern.status.Status;
import com.ticketgo.pattern.strategy.PriceStrategy;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2023-11-05
 */
public class Ticket extends Model<Ticket> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "ticket_id", type = IdType.AUTO)
    private Long ticketId;

    private Long userId;

    private Long showingId;

    private Long seatId;

    private BigDecimal price;

   private Integer status;
    @TableField(exist = false)
    private Status ticketStatus;

    private LocalDateTime createTime;

    private LocalDateTime payTime;

    private LocalDateTime validateTime;

    private Long validateAdminId;

    private LocalDateTime cancelTime;

    //价格策略，按类型出票
    @TableField(exist = false)
    private PriceStrategy priceStrategy;

    //状态模式
    public Result<String> pay(){

        return this.ticketStatus.pay();
    }
    public Result<String> cancel(){
        return this.ticketStatus.cancel();
    }
    public Result<String> validate(){
        return this.ticketStatus.validate();
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowingId() {
        return showingId;
    }

    public void setShowingId(Long showingId) {
        this.showingId = showingId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public LocalDateTime getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(LocalDateTime validateTime) {
        this.validateTime = validateTime;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Status getTicketStatus() {
        return ticketStatus;
    }

    public Long getValidateAdminId() {
        return validateAdminId;
    }

    public void setValidateAdminId(Long validateAdminId) {
        this.validateAdminId = validateAdminId;
    }

    public void setTicketStatus(Status ticketStatus) {
        this.ticketStatus = ticketStatus;
        this.ticketStatus.setTicket(this);
    }

    @Override
    public String toString() {
        return "Ticket{" +
        "ticketId=" + ticketId +
        ", userId=" + userId +
        ", showingId=" + showingId +
        ", seatId=" + seatId +
        ", price=" + price +
        ", status=" + status +
        ", createTime=" + createTime +
        ", payTime=" + payTime +
        ", validateTime=" + validateTime +
        ", cancelTime=" + cancelTime +
        "}";
    }
}
