package com.example.demo.config;

import com.example.demo.handle.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private final MyInterceptor myInterceptor;

    public MyInterceptorConfig(MyInterceptor myInterceptor) {
        this.myInterceptor = myInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //该方法可以给你自己定义的拦截器，定义拦截哪个路径的请求
        //  /**表示拦截所有请求
        String[] addPath = {"/**"};
        // 放行/api/find请求：其中test请求没有对应的处理器
        String[] excludePath = {"/api"};
        registry.addInterceptor(myInterceptor).addPathPatterns(addPath).excludePathPatterns(excludePath);

    }
}
