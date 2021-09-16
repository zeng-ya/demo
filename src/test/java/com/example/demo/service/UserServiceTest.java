package com.example.demo.service;

import com.example.demo.entity.UserName;

import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    private Integer id;
    //为userMapper创建mock对象
    @MockBean
    private UserMapper userMapper;

    //junit测试
    @Test
    public void test1(){
        UserName userName = new UserName(16,"zq");
        userService.insert("wuhu",90);
    }


    @Test
    public void test2(){
        id = 15;
        userService.getByUserID(id);
    }
    @Test
    public void test3(){
        //插桩，调用同一个函数方法，返回值不同
        when(userMapper.getByUserID(11)).thenReturn(new UserName(11,"YZ")).thenThrow(new RuntimeException());

        //第一次调用，得到user对象
        UserName user =userService.getByUserID(11);
        System.out.println(user);
        System.out.println(user.getId());

        //验证是否被执行
        verify(userMapper).getByUserID(11);

        //第二次调用，抛出异常
        System.out.println(userMapper.getByUserID(11));

        //如果没有插桩，应该返回null
        System.out.println(userMapper.getByUserID(12));


        //断言检验
//        Assert.assertNotNull(user);
//        Assert.assertEquals(user.getId(), new Integer(1));

    }
}

