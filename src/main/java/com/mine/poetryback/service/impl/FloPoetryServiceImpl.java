package com.mine.poetryback.service.impl;

import com.mine.poetryback.mapper.FloPoetryMapper;
import com.mine.poetryback.pojo.AnsPoetry;
import com.mine.poetryback.pojo.FloKeywords;
import com.mine.poetryback.pojo.FloPoetry;
import com.mine.poetryback.service.FloPoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloPoetryServiceImpl implements FloPoetryService {

    @Autowired
    private FloPoetryMapper poetryMapper;

    //一次性获取所有关键字
    @Override
    public List<FloKeywords> getAllKeywords() {
        return poetryMapper.getAllKeywords();
    }

    //根据关键字获取诗句  AI
    @Override
    public List<FloPoetry> getVerseAI(String keywords2) {
////        keywords = keywords.substring(1,keywords.length()-1);
//        System.out.println(keywords);//'春'
//        Map<String,Integer> kId = (Map<String, Integer>) poetryMapper.searchKeywordId(keywords);
//        //把所有符合条件的数据都拿到，但符合条件的就一个，是一个数组，有两个元素
////        System.out.println(kId);
////        System.out.println("hello");
//        return poetryMapper.getVerse(kId.get());
//        return null;
//  要使用 严谨查找，即通过关键字id查找，只需取消注释 ！！！ 这两句
        FloKeywords kId = poetryMapper.searchKeywordsId(keywords2);//查询关键字id
//        System.out.println(kId);
        return poetryMapper.getVerse(kId.getKeywordsId());//根据关键字id查询所有
//        return null;
        //对于从数据库中查询得到的数据 结果结构不清晰，
        //@Data注释，添加set、get方法
        //pojo类中变量名需要和数据库中列名相同，默认把从数据库中得到的数据一一赋值给对应pojo类中的变量
        // ，驼峰和下划线命名可转换

//        String modifiedWord = "%" + keywords2 + "%";
//        return poetryMapper.getVerseByWord(modifiedWord);
    }

    //通过用户输入的诗句 获取 数据库诗句
    @Override
    public List<FloPoetry> getVerseUsr(String answer) {
        String modifiedAnswer = "%" + answer.trim() + "%";//用户误敲空格后再输入诗句也能查询
        return poetryMapper.getVerseUsr(modifiedAnswer);
    }


}
