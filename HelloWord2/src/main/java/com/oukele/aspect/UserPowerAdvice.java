package com.oukele.aspect;

import com.oukele.dao.UserMapper;
import com.oukele.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component//注入容器
@Aspect//声明这是一个 切面类
public class UserPowerAdvice {

    @Autowired
    HttpSession session;

    @Autowired
    UserMapper userMapper;

    //切点
    @Pointcut("execution(* com.oukele.controller.*.login(..))")
    public void power() {
    }

    ;

    //环绕通知
    @Around("power()")
    public Object seeStatus(ProceedingJoinPoint joinPoint) {
        try {

            // ......前环绕通知 --> 在原方法还没有执行前先执行

            Object o = joinPoint.proceed();//执行被代理的方法  //环绕通知 能覆盖原方法

            // .......后环绕通知 --> 在原方法执行后执行

            //从session中取出 存储的信息
            User user = (User) session.getAttribute("username");
            //作为 演示 这里的逻辑就随意一写哈
            //如果用户名不为空和密码不为空，去数据库查询，这里呢 我数据库只有用户名和密码
            //所以 我这里 如果 用户名为 oukele 则为管理管 否则都是普通用户
            if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()) {
                //去数据库中查询,结果大于 0 则存在用户 否则
                int result = userMapper.check1(user);
                if (result > 0) {
                    if (user.getUserName().equals("oukele")) {
                        return "{\"msg\":\"该用户 " + user.getUserName() + " 是 管理员\"}";
                    } else {
                        return "{\"msg\":\"该用户 " + user.getUserName() + " 不是 管理员\"}";
                    }
                } else {
                    return "{\"msg\":\"用户不存在。。\"}";
                }
            } else {
                return "{\"msg\":\"用户名或者密码为空。。\"}";
            }


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

}
