package com.moke.springcloud.controller;

import com.moke.springcloud.entities.CommonResult;
import com.moke.springcloud.entities.Payment;
import com.moke.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created by MOKE on 2020/7/6.
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstances == null || serviceInstances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(serviceInstances);
        URI url = instance.getUri();
        return restTemplate.getForObject(url+"/payment/lb",String.class);
    }
}
