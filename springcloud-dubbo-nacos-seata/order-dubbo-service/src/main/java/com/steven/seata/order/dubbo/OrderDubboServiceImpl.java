package com.steven.seata.order.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.steven.seata.dubbo.OrderDubboService;
import com.steven.seata.order.entity.MallOrder;
import com.steven.seata.order.service.OrderService;
import com.steven.seata.vo.MallOrderVo;
import io.seata.core.context.RootContext;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @author steven
 * @desc
 * @date 2021/6/23 11:25
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",timeout = 3000)
public class OrderDubboServiceImpl implements OrderDubboService {

    @Resource
    private OrderService orderService;

    @Override
    public boolean createOrder(MallOrderVo vo) {
        System.out.println("order全局事务id ：" + RootContext.getXID());
        final MallOrder mallOrder = new MallOrder();
        BeanUtils.copyProperties(vo,mallOrder);
        return orderService.createOrder(mallOrder);
    }
}
