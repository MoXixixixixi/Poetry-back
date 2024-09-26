package com.mine.poetryback.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mine.poetryback.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mine.poetryback.service.Aiservice;
@RestController
@CrossOrigin(value = "http://localhost:8080")
public class AiController {
    @Autowired
    private Aiservice aiservice;
    @GetMapping("/AI")
    public Result inquiry(String question){
        String airesponse=aiservice.huida(question);
        JSONObject jsonObj = JSON.parseObject(airesponse);
        return Result.success(jsonObj);
    }
    @GetMapping("/url")
    public Result picture_writing(String url){
        String airesponse=aiservice.testImageToWord(url);
        JSONObject jsonObj = JSON.parseObject(airesponse);
        return Result.success(jsonObj);
    }
    @GetMapping("picture")
    public Result writing_picture(String describe){
        String airesponse=aiservice.testCreateImage(describe);
        JSONObject jsonObj = JSON.parseObject(airesponse);
        return Result.success(jsonObj);
    }
}
