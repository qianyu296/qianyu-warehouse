package com.pn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 供应商表supplier表对应的实体类:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier implements Serializable {

    private Integer supplierId;//供应商id

    private String supplierNum;//供应商代码

    private String supplierName;//供应商名称

    private String supplierIntroduce;//供应商介绍

    private String concat;//供应商联系人

    private String phone;//供应商联系电话

    private String address;//供应商地址

    private String isDelete;//是否删除状态,0未删除,1删除
}
