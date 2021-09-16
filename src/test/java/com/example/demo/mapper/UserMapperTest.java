package com.example.demo.mapper;

import com.example.demo.entity.UserName;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    private Integer id;
    @Test
    public void test(){
        UserName userName = new UserName(99,"YZ");
        userMapper.insert("zy",1);
    }

    @Test
    public void test2(){
        id = 15;
        System.out.println("############");
        System.out.println(userMapper.getByUserID(id));
        System.out.println("222222222222222");
    }
}
