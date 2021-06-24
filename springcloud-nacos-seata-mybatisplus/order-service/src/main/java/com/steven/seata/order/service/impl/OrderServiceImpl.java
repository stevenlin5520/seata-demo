package com.steven.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.steven.seata.order.entity.MallOrder;
import com.steven.seata.order.feign.StockServiceFeignClient;
import com.steven.seata.order.mapper.MallOrderMapper;
import com.steven.seata.order.service.OrderService;
import com.steven.seata.order.vo.MallOrderVo;
import com.steven.seata.util.Result;
import com.steven.seata.vo.MallStockVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:54
 */
@Service
public class OrderServiceImpl extends ServiceImpl<MallOrderMapper,MallOrder> implements OrderService {

    @Resource
    private MallOrderMapper mallOrderMapper;
    @Resource
    private StockServiceFeignClient stockServiceFeignClient;


//    @GlobalTransactional
//    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean createOrder(MallOrderVo vo) {
        final MallOrder target = new MallOrder();
        BeanUtils.copyProperties(vo, target);
        target.setAllPrice(target.getUnitPrice().multiply(new BigDecimal(target.getNum())));
        final boolean b = saveOrUpdate(target);
        System.out.println("b = " + b);

        /*final MallStockVo vo1 = new MallStockVo();
        final Result result = stockServiceFeignClient.reduceStock(vo1);
        System.out.println("result = " + result);*/
        return b;
    }
}
