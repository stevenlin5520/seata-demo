package com.steven.seata.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableNacosDiscovery
@EnableDiscoveryClient
@MapperScan("com.steven.seata.order.mapper")
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.steven.seata.order.dubbo")
public class OrderDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderDubboServiceApplication.class, args);
    }

}
