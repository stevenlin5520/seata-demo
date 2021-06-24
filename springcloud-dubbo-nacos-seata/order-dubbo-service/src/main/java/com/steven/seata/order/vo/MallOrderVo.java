package com.steven.seata.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:03
 */
@Data
public class MallOrderVo {

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
