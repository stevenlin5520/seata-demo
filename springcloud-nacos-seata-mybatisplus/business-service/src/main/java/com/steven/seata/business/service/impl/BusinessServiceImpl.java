package com.steven.seata.business.service.impl;

import com.steven.seata.business.feign.OrderServiceFeignClient;
import com.steven.seata.business.feign.StockServiceFeignClient;
import com.steven.seata.business.service.BusinessService;
import com.steven.seata.util.BusinessException;
import com.steven.seata.util.Result;
import com.steven.seata.vo.MallOrderVo;
import com.steven.seata.vo.MallStockVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:12
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private StockServiceFeignClient stockServiceFeignClient;
    @Resource
    private OrderServiceFeignClient orderServiceFeignClient;


    @GlobalTransactional(timeoutMills = 6000)
//    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result downOrder(String orderCode, int num, BigDecimal unitPrice, int productId) {
        final MallOrderVo mallOrderVo = new MallOrderVo();
        mallOrderVo.setNum(num);
        mallOrderVo.setUnitPrice(unitPrice);
        mallOrderVo.setProductId(productId);
        mallOrderVo.setOrderCode(orderCode);
        mallOrderVo.setUserId(9);
        mallOrderVo.setOrderName("test");
        mallOrderVo.setAllPrice(unitPrice.multiply(new BigDecimal(num)));

        final MallStockVo mallStockVo = new MallStockVo();
        mallStockVo.setProductId(productId);
        mallStockVo.setNum(num);

        final Result orderResult = orderServiceFeignClient.createOrder(mallOrderVo);
        System.out.println("orderResult = " + orderResult);
        final Result stockResult = stockServiceFeignClient.reduceStock(mallStockVo);
        System.out.println("stockResult = " + stockResult);

        if (Result.RESULT_FAIL.equals(orderResult.getCode()) || Result.RESULT_FAIL.equals(stockResult.getCode())) {
            throw new BusinessException("下单失败");
        }
        return Result.success();
    }
}
