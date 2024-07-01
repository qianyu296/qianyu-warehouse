package com.pn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierUpdateDTO implements Serializable {

    private Integer supplierId;//供应商id
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$")
    private String supplierNum;//供应商代码
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fff0-9a-zA-Z_]{2,20}$")
    private String supplierName;//供应商名称
    @Pattern(regexp = "^.{0,500}$")
    private String supplierIntroduce;//供应商介绍
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fffa-zA-Z]{1,20}")
    private String concat;//供应商联系人
    @NotNull
    @Pattern(regexp = "^1[0-9]{10}$")
    private String phone;//供应商联系电话
    @NotNull
    @Pattern(regexp = "[\\u4e00-\\u9fff0-9a-zA-Z_]{0,20}")
    private String address;//供应商地址

    private String isDelete;//是否删除状态,0未删除,1删除
}
