package com.example.demo.service;

import com.example.demo.entity.UserName;
import com.example.demo.handle.MyEvent;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private ApplicationEventPublisher publisher;


    /**
     * 发布事件
     * @return
     */
    public UserName getUser1() {
        UserName user1= new UserName(2, "钟泉");
        // 发布事件,
        MyEvent event = new MyEvent(this,user1);
        //发布事件,让事件相关监听器知道，有这种事件发生
        publisher.publishEvent(event);
        return user1;
    }
    /**
     * 调用mapper层接口insert的方法
     */
    public void insert(String name,Integer id){
        userMapper.insert(name,id);
    }

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    public UserName getByUserID(Integer id){
        return userMapper.getByUserID(id);
    }

    public UserName getUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new UserName(1, "yangzeng");
    }
}


