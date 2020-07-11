package com.moke.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by MOKE on 2020/7/11.
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeginMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeginMain80.class,args);
    }
}
