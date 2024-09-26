package com.mine.poetryback.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//接口响应结果
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;//0-成功 1-失败
    private String message;
    private T data;
    //有数据
    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功", data);
    }
    //没有数据
    public static Result success(){
        return new Result(0, "操作成功",null);
    }
    //失败
    public static Result error(String message){
        return new Result(1,message,null);
    }
}
