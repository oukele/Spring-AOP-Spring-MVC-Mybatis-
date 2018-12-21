package com.oukele.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//声明当前类是配置类 类似于 spring-web.xml 文件
@EnableWebMvc// 若无此注解 WebMvcConfigurer 无效
@ComponentScan(basePackages = {"com.oukele.controller","com.oukele.aspect"})//扫描控制层 和切面包
@EnableAspectJAutoProxy// 激活 切面 代理
public class SpringWebConfig implements WebMvcConfigurer {
    //注册静态资源，没注册的话，网站是访问不了的
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
    }



}
