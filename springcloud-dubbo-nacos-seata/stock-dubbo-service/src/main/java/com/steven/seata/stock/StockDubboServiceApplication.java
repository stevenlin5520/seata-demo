package com.steven.seata.stock;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableNacosDiscovery
@EnableDiscoveryClient
@MapperScan("com.steven.seata.stock.mapper")
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.steven.seata.stock.dubbo")
public class StockDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockDubboServiceApplication.class, args);
    }

}
