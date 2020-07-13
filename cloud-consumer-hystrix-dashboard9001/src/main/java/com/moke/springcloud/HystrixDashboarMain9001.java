package com.moke.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by MOKE on 2020/7/13.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboarMain9001 {
    public static void main(String[] args){
        SpringApplication.run(HystrixDashboarMain9001.class,args);
    }
}
