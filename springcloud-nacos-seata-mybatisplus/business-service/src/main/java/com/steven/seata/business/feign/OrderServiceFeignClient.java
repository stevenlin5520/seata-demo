package com.steven.seata.business.feign;

import com.steven.seata.util.Result;
import com.steven.seata.vo.MallOrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:14
 */
@FeignClient("order-service")
public interface OrderServiceFeignClient {

    @PostMapping("order/createOrder")
    Result createOrder(@RequestBody MallOrderVo vo);

}
