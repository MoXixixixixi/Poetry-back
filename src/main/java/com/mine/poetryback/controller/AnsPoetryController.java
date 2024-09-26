package com.mine.poetryback.controller;

import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.Category;
import com.mine.poetryback.pojo.Result;
import com.mine.poetryback.service.AnsPoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
//诗文对答 有获取诗词种类
@RequestMapping("/poetry")
public class AnsPoetryController {
    @Autowired //注入ioc容器
    private AnsPoetryService ansPoetryService;

    @GetMapping ("/category")   //获取诗词种类
    public Result<List<Category>> list(){
        List<Category> cs = ansPoetryService.list();
        return Result.success(cs);
    }

    @GetMapping("/getWhole")//获取pg所有诗句
    public Result<List<AnsPoetry>> getWhole(){
        List<AnsPoetry> gw = ansPoetryService.getWhole();
        return Result.success(gw);
    }
}