package com.moke.springcloud.service.impl;

import com.moke.springcloud.dao.PaymentDao;
import com.moke.springcloud.entities.Payment;
import com.moke.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by MOKE on 2020/7/5.
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    };

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    };
}
