package com.mine.poetryback.service;

import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.FloKeywords;
import com.mine.poetryback.pojo.FloPoetry;

import java.util.List;

public interface FloPoetryService {

    //一次性获取所有关键字
    List<FloKeywords> getAllKeywords();

    //通过 关键字 获取诗句
    List<FloPoetry> getVerseAI(String keywords);

    //通过用户输入 获取 数据库诗句
    List<FloPoetry> getVerseUsr(String answer);
}
