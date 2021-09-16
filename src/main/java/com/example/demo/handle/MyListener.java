package com.example.demo.handle;

import com.example.demo.entity.UserName;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器就是监听事件，主要是三大作用域对象的创建，销毁以及里面的属性的添加，修改，删除，获取
 *监听挺成功后，可以进行处理
 * 也可以自定义事件，继承ApplicationEvent
 */
@Slf4j
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> , HttpSessionListener , ServletRequestListener {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到 application 上下文,从被监听的事件中获取上下文对象
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取对应的 service
        UserService userService = applicationContext.getBean(UserService.class);
        //调用里面的获取UserName对象方法
        UserName userName = userService.getUser();
        /*
        获取 application 域对象，将查到的信息放到 application 域中,
        该servletcontext对象在项目启动时会创建一个，里面的属性可以共享
         */
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user", userName);

    }

    /**
     * 记录在线的用户数量
     */
    public Integer count = 0;

    @Override
    /*
    用户登录时服务器都会为该用户创建一个session,用户退出的时候销毁会话，监听该事件可以记录在线人数
     */
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("新用户上线了");
        count++;
        //通过事件获取Session对象，在通过session对象获取servletcontext对象，往里面插值
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
        log.info("当前用户数量：" + count);
    }


    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("用户下线了");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
        log.info("当前用户数量：" + count);
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        log.info("session id为：{}", request.getRequestedSessionId());
        log.info("request url为：{}", request.getRequestURL());
        request.setAttribute("name", "杨增");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        log.info("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        log.info("request域中保存的name值为：{}", request.getAttribute("name"));

    }
}
