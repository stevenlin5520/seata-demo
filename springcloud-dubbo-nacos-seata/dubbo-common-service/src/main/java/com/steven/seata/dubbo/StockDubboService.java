package com.steven.seata.dubbo;

import com.steven.seata.vo.MallStockVo;

/**
 * @author steven
 * @desc
 * @date 2021/6/23 11:08
 */
public interface StockDubboService {

    boolean reduceStock(MallStockVo stock);

}
