package com.steven.seata.business;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableNacosDiscovery
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.call")
public class BusinessDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessDubboServiceApplication.class, args);
    }

}
