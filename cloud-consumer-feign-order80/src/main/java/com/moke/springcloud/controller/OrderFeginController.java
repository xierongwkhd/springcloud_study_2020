package com.moke.springcloud.controller;

import com.moke.springcloud.entities.CommonResult;
import com.moke.springcloud.entities.Payment;
import com.moke.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by MOKE on 2020/7/11.
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeginController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPyamentById(@PathVariable("id")Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/payment/fegin/timeout")
    public String paymentFeginTimeout(){
        return paymentService.paymentFeginTimeout();
    }
}
