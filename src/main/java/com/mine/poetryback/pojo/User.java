package com.mine.poetryback.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private int id;//ID

    private String username;//用户名

    @JsonIgnore//让springmvc把当前对象转化成json对象时，忽略password，最终的json字符串中没有password属性
    private String password;//密码

    private String selfDescription;//自我简介

    private String like;//喜好
}
