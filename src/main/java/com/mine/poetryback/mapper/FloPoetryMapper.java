package com.mine.poetryback.mapper;

import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.FloKeywords;
import com.mine.poetryback.pojo.FloPoetry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FloPoetryMapper {

    //获取所有关键字
    @Select("select  * from flo_keywords_table")
    List<FloKeywords> getAllKeywords();

    //根据关键字查询关键字id
    @Select("select * from flo_keywords_table where keywords=#{keywords}")
    FloKeywords searchKeywordsId(String keywords);//返回的是对应每一列找到的每一个数据，即 （多个）整行

    //通过关键字id查询所有诗句
    @Select("select * from flo_poetry_table where keywords_id = #{keywordsId}")//concat('%', #{keywordsId}, '%')
    List<FloPoetry> getVerse(Integer keywordsId);


    //根据用户输入诗句 获取 数据库诗句 //因数据库结构，只能用模糊搜索 impl中加通配符
    @Select("select * from flo_poetry_table where poetry like #{modifiedAnswer}")
    List<FloPoetry> getVerseUsr(String modifiedAnswer);




    //关键字，在整个数据库中搜索含此关键字的诗句，因数据库结构问题，只有诗名中含有该关键字也会获取到
    //为了让 数据库所有诗在一张表里 造成的损失 降到 最小 ，故增加此方法 ，不然很轻易就会造成 诗句已出现 的弹框（即使实际上不满足弹出的条件）
    //一句诗中可能含有多个关键词， 数据库应弄成 每个关键字对应一张表
    //此方法 只 能用   模糊搜索
    @Select("select * from flo_poetry_table where substring(poetry, 1, 15) like #{modifiedWord}")
    List<FloPoetry> getVerseByWord(String modifiedWords);//添加通配符的关键字
}
