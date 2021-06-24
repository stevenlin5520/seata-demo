package com.steven.seata.business.controller;

import com.steven.seata.business.service.BusinessService;
import com.steven.seata.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 13:06
 */
@RestController
@RequestMapping("business")
public class BusinessController {

    @Resource
    private BusinessService businessService;

    @GetMapping("downOrder")
    public Result downOrder(String orderCode, int num, BigDecimal unitPrice, int productId){
        final Result result = businessService.downOrder(orderCode, num, unitPrice, productId);
        return result;
    }

}
