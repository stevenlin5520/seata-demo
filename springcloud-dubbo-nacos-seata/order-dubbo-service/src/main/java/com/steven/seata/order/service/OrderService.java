package com.steven.seata.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.steven.seata.order.entity.MallOrder;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:06
 */
public interface OrderService extends IService<MallOrder> {

    boolean createOrder(MallOrder mallOrder);

}
