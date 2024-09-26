package com.mine.poetryback.service.impl;

import com.mine.poetryback.mapper.AnsPoetryMapper;
import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.Category;
import com.mine.poetryback.service.AnsPoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnsPoetryServiceImpl implements AnsPoetryService {

    @Autowired
    private AnsPoetryMapper ansPoetryMapper;

    //获取诗句种类
    @Override
    public List<Category> list() {
        return ansPoetryMapper.list();
    }

    //获取pg所有诗句
    @Override
    public List<AnsPoetry> getWhole() {
        return ansPoetryMapper.getWhole();
    }


}
