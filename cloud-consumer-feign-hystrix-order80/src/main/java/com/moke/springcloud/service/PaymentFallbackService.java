package com.moke.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by MOKE on 2020/7/13.
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,...";
    }

    @Override
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,...";
    }
}
