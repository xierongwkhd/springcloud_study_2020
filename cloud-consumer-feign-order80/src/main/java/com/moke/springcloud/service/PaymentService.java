package com.moke.springcloud.service;

import com.moke.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by MOKE on 2020/7/11.
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/fegin/timeout")
    public String paymentFeginTimeout();
}
