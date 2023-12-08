package com.ticketgo.util.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "通用的返回结果")
public class Result<T> implements Serializable {

    @Schema(description = "编码：1成功，0和其它数字为失败", required = true, example = "1 成功")
    private Integer code; // 编码：1成功，0和其它数字为失败
    @Schema(description = "返回消息", example = "密码错误")
    private String msg; // 错误信息
    @Schema(description = "返回数据", example = "movieId:2 movieName:Haha")
    private T data; // 数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.code = 0;
        return result;
    }
}