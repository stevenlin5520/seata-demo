package com.steven.seata.stocks.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:14
 */
@Data
@TableName("mall_stock")
public class MallStock implements Serializable {

    @TableId
    private int id;
    private int productId;
    private int num;
}
