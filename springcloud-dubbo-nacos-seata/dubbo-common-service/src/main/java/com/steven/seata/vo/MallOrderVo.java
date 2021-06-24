package com.steven.seata.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:03
 */
@Data
public class MallOrderVo implements Serializable {

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
