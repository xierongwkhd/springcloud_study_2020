package com.moke.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * Created by MOKE on 2020/7/12.
 */
@Service
public class PaymentService {

    /*
    正确的方法
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+ currentThread().getName()+" paymentInfo_OK,id："+id+"\t"+"???";
    }

    /*
    会超时报错的方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ currentThread().getName()+" paymentInfo_TimeOut,id："+id+"\t"+"！！！";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+ currentThread().getName()+" 8001系统繁忙，请稍后再试,id："+id+"\t"+"。。。";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0)
            throw new RuntimeException("****id 不能为负数");
        String serialNumber = IdUtil.simpleUUID();//hutool工具
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id："+id+"，不能为负数，请稍后再试，。。。";
    }
}
