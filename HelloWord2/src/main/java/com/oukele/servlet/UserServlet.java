package com.oukele.servlet;

import com.oukele.dao.UserMapper;
import com.oukele.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServlet {

    @Autowired
    private UserMapper userMapper;

    public Boolean checkUser(User user){
        //根据传进来的参数，去数据库查找用户
        int result = userMapper.check(user);
        //如果查回来的结果不为零，说明数据库中有该用户，让他登陆，否则不让他登陆
        if( result > 0 ){
            return true;
        }
        return false;
    }

}
