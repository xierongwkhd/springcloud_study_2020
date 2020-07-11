package com.moke.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by MOKE on 2020/7/11.
 */
public interface LoadBalancer {
    //从服务列表中选取一个服务
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
