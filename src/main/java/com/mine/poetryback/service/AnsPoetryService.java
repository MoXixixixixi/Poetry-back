package com.mine.poetryback.service;

import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.Category;

import java.util.List;

public interface AnsPoetryService {
    //获取诗歌分类
    List<Category> list();

    //获取pg所有诗句
    List<AnsPoetry> getWhole();

}
