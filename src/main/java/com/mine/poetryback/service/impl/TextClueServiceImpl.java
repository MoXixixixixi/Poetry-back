package com.mine.poetryback.service.impl;

import com.mine.poetryback.mapper.TextClueMapper;
import com.mine.poetryback.pojo.TextClue;
import com.mine.poetryback.service.TextClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextClueServiceImpl implements TextClueService {

    @Autowired
    private TextClueMapper textClueMapper;

    //获取所有题目
    @Override
    public List<TextClue> getWhole() {
        return textClueMapper.getWhole();
    }
}
