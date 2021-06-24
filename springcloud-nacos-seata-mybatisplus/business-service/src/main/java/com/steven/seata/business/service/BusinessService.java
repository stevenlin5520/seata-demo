package com.steven.seata.business.service;

import com.steven.seata.util.Result;

import java.math.BigDecimal;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:10
 */
public interface BusinessService {

    Result downOrder(String orderCode, int num, BigDecimal unitPrice, int productId);
}
