package com.example.demo.handle;


import com.example.demo.entity.UserName;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
public class MyEvent extends ApplicationEvent {
    private UserName userName;

    public MyEvent(Object source,UserName userName) {
        super(source);
        this.userName = userName;
    }

    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }
}
