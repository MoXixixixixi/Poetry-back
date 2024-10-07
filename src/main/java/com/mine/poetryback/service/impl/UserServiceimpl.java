package com.mine.poetryback.service.impl;

import com.mine.poetryback.mapper.UserMapper;
import com.mine.poetryback.pojo.User;
import com.mine.poetryback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //查询用户名
    @Override
    public User findByUsername(String username) {
        User u = userMapper.findByUsername(username);
        return u;
    }

    //注册
    @Override
    public void register(String username, String password) {
        //添加
        userMapper.add(username,password);//common为普通权限
    }
}
