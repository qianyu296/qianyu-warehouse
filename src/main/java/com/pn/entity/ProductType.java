package com.pn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * 商品分类表product_type表对应的实体类:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductType implements Serializable {
    @NotNull
    private Integer typeId;//分类id

    private Integer parentId;//上级分类id
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$")
    private String typeCode;//分类编码
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fff0-9a-zA-Z]{1,20}$")
    private String typeName;//分类名称
    @Pattern(regexp = "^.{0,500}$")
    private String typeDesc;//分类描述

    //自定义List<ProductType>集合属性,用于存储当前分类的所有子级分类
    private List<ProductType> childProductCategory;
}
