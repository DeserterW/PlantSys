package com.why.plant.common.model;


/**
 * 统一返回结果
 * @author why
 * @date 2022/5/2 18:01 下午
 **/
public class Result<T>{
    boolean success;
    String msg;
    T data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("OK");
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("OK");
        result.setData(data);
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(message);
        return result;
    }
}

