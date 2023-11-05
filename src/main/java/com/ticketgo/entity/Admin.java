package com.ticketgo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

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
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;


      @TableId(value = "admin_id", type = IdType.AUTO)
    private Long adminId;

    @Schema(description = "用户名", required = true)
    private String adminName;

    private String password;

    private String email;

    private LocalDateTime createTime;


    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }



    @Override
    public String toString() {
        return "Admin{" +
        "adminId=" + adminId +
        ", adminName=" + adminName +
        ", password=" + password +
        ", email=" + email +
        ", createTime=" + createTime +
        "}";
    }
}
