package com.steven.seata.business.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.steven.seata.business.service.BusinessService;
import com.steven.seata.dubbo.OrderDubboService;
import com.steven.seata.dubbo.StockDubboService;
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

    @Reference(version = "1.0.0")
    private OrderDubboService orderDubboService;
    @Reference(version = "1.0.0")
    private StockDubboService stockDubboService;


    @GlobalTransactional(timeoutMills = 6000, name = "business-dubbo-service-seata")
    @Transactional(rollbackFor = Exception.class)
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

        final boolean orderResult = orderDubboService.createOrder(mallOrderVo);
        System.out.println("orderResult = " + orderResult);
        final boolean stockResult = stockDubboService.reduceStock(mallStockVo);
        System.out.println("stockResult = " + stockResult);

        return Result.success();
    }
}
