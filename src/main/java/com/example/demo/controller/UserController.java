package com.example.demo.controller;

import com.example.demo.entity.UserName;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 接收插入数据的请求
     */
    @PostMapping("/insert")
    public String insert(@RequestParam("name") String name,  @RequestParam("id") Integer id){
        userService.insert(name,id);
        return "插入成功";
    }

    /**
     * 根据输入的ID查找用户信息
     * @param id
     * @return
     */
    @GetMapping("/find")
    public UserName getByUserID(Integer id){
        return userService.getByUserID(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user")
    /**
     * 从http请求中获取servletcontext对象
     */
    public UserName getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (UserName) application.getAttribute("user");
    }
    /**
     * 获取当前在线人数
     * 也是需要从http请求里面获取
     * @param request
     * @return
     */
    @GetMapping("/total")
    public Integer getTotalUser(HttpServletRequest request) {
        int count = (int) request.getSession().getServletContext().getAttribute("count");
        System.out.println("调用方法打印："+count);
        return count;
    }
    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }
    @GetMapping("/user1")
    public UserName getUser1(){
        return userService.getUser1();
    }

}
