package com.steven.seata.business.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @desc  
 * @author steven
 * @date 2021/6/23-11:33
 */
@Configuration
public class SeataAutoConfig {

    /**
     * init global transaction scanner
     *
     * @Return: GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("business-service-seata", "demo-tx-grp");
    }
}
