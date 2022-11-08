package ir.cactus.restspringapi.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSchduler {
    @Scheduled(fixedDelay = 1000)
    public void taskOne(){
        System.out.println("task running");
    }

    @Scheduled(fixedDelay = 1000)
    @Async
    public void Task2(){
        System.out.println("task from another thread");
    }
    @Scheduled(cron = "${cronExpression}")
    public  void Task3(){
        System.out.println("task with coron is running");
    }

}
