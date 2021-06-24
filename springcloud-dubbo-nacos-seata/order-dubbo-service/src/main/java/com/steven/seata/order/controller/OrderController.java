package com.steven.seata.order.controller;

import com.steven.seata.order.entity.MallOrder;
import com.steven.seata.order.service.OrderService;
import com.steven.seata.order.vo.MallOrderVo;
import com.steven.seata.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:00
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;


    @PostMapping("createOrder")
    public Result createOrder(@RequestBody MallOrderVo vo){
        final MallOrder mallOrder = new MallOrder();
        BeanUtils.copyProperties(vo,mallOrder);
        final boolean order = orderService.createOrder(mallOrder);
        if(order){
            return Result.success();
        }
        return Result.failed();
    }


    @PostMapping("createOrder2")
    public Result createOrder2(@RequestBody MallOrderVo vo){
        final MallOrder mallOrder = new MallOrder();
        BeanUtils.copyProperties(vo,mallOrder);
        final boolean order = orderService.createOrder(mallOrder);
        if(order){
            return Result.success();
        }
        return Result.failed();
    }
}
