package com.mine.poetryback.mapper;

import com.mine.poetryback.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //根据用户名查询用户
    @Select("select * from competition_database.user where username=#{username}")
    User findByUsername(String username);

    //添加
    @Insert("insert into competition_database.user(username,password)" + "values(#{username},#{password})")
    void add(String username, String password);
}
