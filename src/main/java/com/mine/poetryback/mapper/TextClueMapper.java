package com.mine.poetryback.mapper;

import com.mine.poetryback.pojo.TextClue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TextClueMapper {

    //获取所有题目
    @Select("select * from clue")
    List<TextClue> getWhole();
}
