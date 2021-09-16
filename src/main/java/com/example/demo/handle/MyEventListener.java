package com.example.demo.handle;

import com.example.demo.entity.UserName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import javax.servlet.annotation.WebListener;
@Slf4j
@WebListener
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        //从事件中获取用户对象
        UserName user = myEvent.getUserName();

        log.info("用户ID："+user.getId());
        log.info("用户姓名："+user.getName());
    }
}
