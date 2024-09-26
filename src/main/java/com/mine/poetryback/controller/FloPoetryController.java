package com.mine.poetryback.controller;

import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.FloKeywords;
import com.mine.poetryback.pojo.FloPoetry;
import com.mine.poetryback.pojo.Result;
import com.mine.poetryback.service.FloPoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
// 飞 花 令
@RequestMapping("/floPoetry")
public class FloPoetryController {
    @Autowired
    private FloPoetryService poetryService;

    @GetMapping("/keywords")//获取飞花令所有关键词
    public Result<List<FloKeywords>> getAllKeywords(){
        List<FloKeywords> ak = poetryService.getAllKeywords();
        return Result.success(ak);
    }

    @GetMapping ("/AI") //飞花令 AI 获取诗句  //通过关键词获取
    public Result<List<FloPoetry>> getVerseAI(String keywords){
        List<FloPoetry> gv = poetryService.getVerseAI(keywords);
//        System.out.println(keywords);
        return Result.success(gv);
    }
    @GetMapping("/usr")//飞花令 通过用户输入诗句 获取 数据库诗句
    public Result<List<FloPoetry>> getVerseUsr(String answer){//不是诗文对答，用模糊搜索实现，而非pg表中的上下诗句
        List<FloPoetry> pg = poetryService.getVerseUsr(answer);
        return Result.success(pg);
    }
}
