package com.steven.seata.business.feign;

import com.steven.seata.util.Result;
import com.steven.seata.vo.MallStockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:18
 */
@FeignClient("stock-service")
public interface StockServiceFeignClient {

    @PostMapping("stock/reduceStock")
    Result reduceStock(@RequestBody MallStockVo vo);

}
