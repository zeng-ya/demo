package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration //配置类必备注解，将该类丢进容器中，
@ConfigurationProperties(prefix = "com.weiz.resource")//默认的配置文件中的值，需要修改配置文件的话用propertysource

public class WebSiteConfig {
    private final String name;
    private final String language;

    public WebSiteConfig(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }
    public String getLanguage() {
        return language;
    }

}
