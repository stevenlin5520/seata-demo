package com.steven.seata.stocks.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.steven.seata.stocks.entity.MallStock;
import com.steven.seata.stocks.mapper.MallStockMapper;
import com.steven.seata.stocks.service.MallStockService;
import com.steven.seata.util.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author steven
 * @desc 库存服务
 * @date 2021/6/17 15:23
 */
@Service
public class MallStockServiceImpl extends ServiceImpl<MallStockMapper, MallStock> implements MallStockService{

    @Resource
    private MallStockMapper mallStockMapper;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean reduceStock(MallStock stock){
        final LambdaQueryWrapper<MallStock> queryWrapper = new QueryWrapper<MallStock>().lambda().eq(MallStock::getProductId, stock.getProductId());
        final MallStock mallStock = getOne(queryWrapper);
        if(mallStock == null){
            throw new BusinessException("未找到商品");
        }

        mallStock.setNum(mallStock.getNum()-1);
        return updateById(mallStock);
    }
}
