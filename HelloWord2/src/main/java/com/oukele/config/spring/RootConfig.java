package com.oukele.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration//声明当前类 是一个 配置类
@ComponentScan(basePackages = "com.oukele.dao")//扫描 dao包 使用spring 注解的接口
@Import({SpringDaoConfig.class,SpringServlet.class})//导入其他配置
public class RootConfig {

}
