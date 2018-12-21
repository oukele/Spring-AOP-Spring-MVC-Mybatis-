package com.oukele.dao;

import com.oukele.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    //使用xml配置文件
    int check(User user);
    //使用注解
    @Select("select count(*) from user where userName = #{userName} and password = #{password}")
    int check1(User user);

}
