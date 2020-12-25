package com.cenozoic.number.dto;

import com.cenozoic.number.constant.Constant;
import lombok.Data;

@Data
public class Resp<T> {


    private Integer status;
    private String message;
    private T data;

    public Resp() {
    }

    private Resp(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private Resp(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Resp success(String message, Object data) {
        return new Resp<>(Constant.RespStatus.SUCCESS.getCode(), message, data);
    }

    public static Resp success() {
        return new Resp<>(Constant.RespStatus.SUCCESS.getCode(), "ok", null);
    }

    public static Resp success(Object data) {
        return new Resp<>(Constant.RespStatus.SUCCESS.getCode(), "ok", data);
    }


    public static Resp fail(Integer status, String message, Object data) {
        return new Resp<>(status, message, data);
    }

    public static Resp fail(Integer status, String message) {
        return new Resp<>(status, message);
    }

    public static Resp fail(String message) {
        return new Resp<>(Constant.RespStatus.FAIL.getCode(), message);
    }

    public static Resp paramError() {
        return new Resp<>(Constant.RespStatus.FAIL.getCode(), "参数错误");
    }

    public static Resp error() {
        return new Resp<>(Constant.RespStatus.ERROR.getCode(), "系统繁忙，请稍后再试");
    }
}
