package com.oukele.controller;

import com.oukele.entity.User;
import com.oukele.servlet.UserServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserServlet userServlet;

    @RequestMapping(path = "/login/{name}/{password}", method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String login(@PathVariable("name") String name, @PathVariable("password") String password, HttpSession session) {
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        session.setAttribute("username",user);//存入session中
        Boolean aBoolean = userServlet.checkUser(user);

        if(aBoolean){
            return "{\"msg\":\"登入成功\"}";
        }

        return "{\"msg\":\"登入失败\"}";
    }

    @GetMapping(path = "/Ioc")
    public HashMap<String, String[]> getAllInfo() {

        return new HashMap<String, String[]>() {{
            put("子容器", webApplicationContext.getBeanDefinitionNames());
            put("父容器", Objects.requireNonNull(webApplicationContext.getParent().getBeanDefinitionNames()));
        }};

    }

}
