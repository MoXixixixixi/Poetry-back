package com.mine.poetryback.service;

import com.mine.poetryback.pojo.User;

public interface UserService {

    //根据用户名查询用户
    User findByUsername(String username);

    //注册
    void register(String username, String password);
}
