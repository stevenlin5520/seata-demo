package com.steven.seata.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author steven
 * @desc
 * @date 2021/6/17 16:20
 */
@Data
public class MallStockVo implements Serializable {
    private int id;
    private int productId;
    private int num;
}
