package com.steven.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.steven.seata.order.entity.MallOrder;
import com.steven.seata.order.mapper.MallOrderMapper;
import com.steven.seata.order.service.OrderService;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean createOrder(MallOrder mallOrder) {
        mallOrder.setAllPrice(mallOrder.getUnitPrice().multiply(new BigDecimal(mallOrder.getNum())));
        return saveOrUpdate(mallOrder);
    }
}
