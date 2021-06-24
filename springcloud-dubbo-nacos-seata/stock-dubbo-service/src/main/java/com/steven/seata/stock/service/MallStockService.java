package com.steven.seata.stock.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.steven.seata.stock.entity.MallStock;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:22
 */
public interface MallStockService extends IService<MallStock> {

    boolean reduceStock(MallStock mallStock);

}
