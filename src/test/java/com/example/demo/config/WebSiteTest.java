package com.example.demo.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSiteTest {
    @Autowired
    //注入配置类对象，该对象中的属性都是指定的配置文件中的属性值
    private WebSiteConfig webSiteConfig;
    //用value注解读取配置文件中的参数
    @Value("${com.weiz.resource.language}")
    private String java;
    @Test
    public void test1(){
        System.out.println(webSiteConfig.getLanguage());
        System.out.println(java);
    }
}
