package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //定时器功能开启
@ServletComponentScan //自动扫描webfilter、weblistener注解的类，并创建对象，纳入Applicationcontext对象中
@MapperScan("com.example.demo.mapper")//该注解会扫描mapper包里面的文件
public class DemoApplication {
		public static void main (String[]args){

			SpringApplication.run(DemoApplication.class, args);
		}
}
