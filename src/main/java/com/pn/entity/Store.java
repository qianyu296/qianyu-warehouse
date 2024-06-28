package com.pn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 仓库表store表对应的实体类:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Store implements Serializable {

    private Integer storeId;//仓库id
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fff0-9a-zA-Z_]{4,20}$")
    private String storeName;//仓库名称
    @NotNull
    @Pattern(regexp = "^\\w{4,20}$")
    private String storeNum;//仓库编码
    @Pattern(regexp = "^[\\u4e00-\\u9fff0-9a-zA-Z_]{0,20}$")
    private String storeAddress;//仓库地址
    @Pattern(regexp = "^[\\u4e00-\\u9fffa-zA-Z]{0,20}$")
    private String concat;//仓库联系人
    @Pattern(regexp = "^[0-9]{11}$")
    private String phone;//仓库联系电话
}
