package com.steven.seata.stock.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.steven.seata.dubbo.StockDubboService;
import com.steven.seata.stock.entity.MallStock;
import com.steven.seata.stock.service.MallStockService;
import com.steven.seata.vo.MallStockVo;
import io.seata.core.context.RootContext;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @author steven
 * @desc
 * @date 2021/6/23 11:07
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",timeout = 3000)
public class StockDubboServiceImpl implements StockDubboService {

    @Resource
    private MallStockService mallStockService;

    @Override
    public boolean reduceStock(MallStockVo vo) {
        System.out.println("stock全局事务id ：" + RootContext.getXID());
        final MallStock mallStock = new MallStock();
        BeanUtils.copyProperties(vo,mallStock);
        return mallStockService.reduceStock(mallStock);
    }
}
