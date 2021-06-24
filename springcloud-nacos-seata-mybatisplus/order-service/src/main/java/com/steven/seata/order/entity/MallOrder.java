package com.steven.seata.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 15:11
 */
@Data
@TableName("mall_order")
public class MallOrder implements Serializable {

    @TableId
    private int id;
    private String orderName;
    private String orderCode;
    private int userId;
    private int productId;
    private int num;
    private BigDecimal unitPrice;
    private BigDecimal allPrice;
    private Date createTime;
}
