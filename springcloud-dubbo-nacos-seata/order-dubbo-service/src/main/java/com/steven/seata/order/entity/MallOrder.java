package com.steven.seata.order.entity;

import com.baomidou.mybatisplus.annotation.*;
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

    @TableId(value = "id",type = IdType.AUTO)
    @TableField("id")
    private Integer id;
    private String orderName;
    private String orderCode;
    private Integer userId;
    private Integer productId;
    private Integer num;
    private BigDecimal unitPrice;
    private BigDecimal allPrice;
    private Date createTime;
}
