package com.moke.springcloud.service;

import com.moke.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by MOKE on 2020/7/5.
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
