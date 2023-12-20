package com.traning.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result <T>{
    private static final Integer OK = 0;
    private static final Integer ERROR = -1;


    private Integer code;//返回码
    private String message;//返回信息;
    private T data;//返回携带数据

    public static <E> Result<E> success(E data){
        return new Result<>(OK, "操作成功", data);
    }

    public static <E> Result<E> success(){
        return new Result<>(OK, "操作成功", null);
    }

    public static <E> Result<E> error(String message){
        return new Result<>(ERROR, message, null);
    }
}
