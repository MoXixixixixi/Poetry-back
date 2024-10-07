package com.mine.poetryback.controller;

import com.mine.poetryback.pojo.Result;
import com.mine.poetryback.pojo.User;
import com.mine.poetryback.service.UserService;
import com.mine.poetryback.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册接口
    @PostMapping("/register")
    //Pattern注释是参数校验
    public Result register(@Pattern(regexp = "^\\S{3,10}$") String username, @Pattern(regexp = "^\\S{6,15}$") String password){
        //根据用户名查询用户
        User u = userService.findByUsername(username);
        if(u==null){
            //没有占用用户名
            //注册
            userService.register(username,password);
            return Result.success();
        }
        else{
            //占用用户名
            return Result.error("用户名已经被占用");
        }
    }

    //登录
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{3,10}$") String username,@Pattern(regexp = "^\\S{6,15}$") String password){
        //根据用户名查询用户
        User loginUser = userService.findByUsername(username);
        //判断用户名是否存在
        if(loginUser==null){
            return Result.error("用户名错误");
        }
        //判断密码是否正确 loginUser对象中的password是密文
        if (password.equals(loginUser.getPassword())){
            //登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
}
