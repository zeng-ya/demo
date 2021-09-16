package com.example.demo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FirstScheduled {


    @Scheduled(fixedRate = 3000) //：上一次开始执行时间点之后 3 秒再执行（fixedRate 属性：定时任务开始后再次执行定时任务的延时（需等待上次定时任务完成），单位毫秒）
   // @Scheduled(fixedDelay = 3000) ：上一次执行完毕时间点之后 3 秒再执行（fixedDelay 属性：定时任务执行完成后再次执行定时任务的延时（需等待上次定时任务完成），单位毫秒）
   // @Scheduled(initialDelay = 1000, fixedRate = 3000) ：第一次延迟1秒后执行，之后按fixedRate的规则每 3 秒执行一次（initialDelay 属性：第一次执行定时任务的延迟时间，需配合fixedDelay或者fixedRate来使用）
    //@Scheduled(cron="0 0 2 1 * ? *") ：通过cron表达式定义规则
    public void scheduledTask() throws InterruptedException {
        System.out.println("任务执行时间：" + LocalDateTime.now());
        Thread.sleep(10000);//任务暂停时间
    }
}
