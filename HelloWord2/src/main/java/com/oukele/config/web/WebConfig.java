package com.oukele.config.web;

import com.oukele.config.mvc.SpringWebConfig;
import com.oukele.config.spring.RootConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;


public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {// (spring容器) 父容器
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//  (spring mvc容器)  子容器
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {//映射
        return new String[]{"/"};
    }


    //设置编码
    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
