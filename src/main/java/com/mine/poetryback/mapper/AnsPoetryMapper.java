package com.mine.poetryback.mapper;

import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnsPoetryMapper {
    //获取诗的种类
    @Select("select * from pg_subject_table")
    List<Category> list();

    //获取pg所有诗句
    @Select("select * from pg_poetry_table")
    List<AnsPoetry> getWhole();
}
