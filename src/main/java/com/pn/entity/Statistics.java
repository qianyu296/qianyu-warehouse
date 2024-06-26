package com.pn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统计实体类:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {

    private Integer storeId;//仓库id

    private String storeName;//仓库名称

    private Integer totalInvent;//仓库商品库存数

    private Integer typeId;// 商品类型id
    private String typeName;// 商品类型名称
    private Integer buyNum;// 商品类型总和
}
