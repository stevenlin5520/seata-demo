package com.steven.seata.stock.controller;

import com.steven.seata.stock.entity.MallStock;
import com.steven.seata.stock.service.MallStockService;
import com.steven.seata.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:38
 */
@RestController
@RequestMapping("stock")
public class StockController {

    @Resource
    private MallStockService mallStockService;

    @PostMapping("reduceStock")
    public Result reduceStock(@RequestBody MallStock mallStock){
        final boolean reduceStock = mallStockService.reduceStock(mallStock);
        if(reduceStock) {
            return Result.success();
        }
        return Result.failed();
    }

}
