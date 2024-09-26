package com.mine.poetryback.controller;

import com.mine.poetryback.pojo.Result;
import com.mine.poetryback.pojo.TextClue;
import com.mine.poetryback.service.TextClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("textClue")
public class TextClueController {

    @Autowired
    private TextClueService textClueService;

    //获取所有题目
    @GetMapping("getWhole")
    public Result<List<TextClue>> getWhole(){
        List<TextClue> tx =  textClueService.getWhole();
        return Result.success(tx);
    }
}
