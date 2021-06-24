package com.steven.seata.dubbo;

import com.steven.seata.vo.MallOrderVo;

/**
 * @author steven
 * @desc
 * @date 2021/6/23 11:24
 */
public interface OrderDubboService {

    boolean createOrder(MallOrderVo vo);

}
