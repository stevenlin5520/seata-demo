package com.steven.seata.stocks.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.steven.seata.stocks.entity.MallStock;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:22
 */
public interface MallStockService extends IService<MallStock> {

    boolean reduceStock(MallStock mallStock);

}
