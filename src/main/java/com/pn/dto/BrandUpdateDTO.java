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
public class BrandUpdateDTO implements Serializable {

    private Integer brandId;//品牌id
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fff0-9a-zA-Z]{1,10}$")
    private String brandName;//品牌名称
    @Pattern(regexp = "^[a-zA-Z]{1}$")
    private String brandLeter;//品牌首字母
    @Pattern(regexp = "^.{0,500}$")
    private String brandDesc;//品牌描述
}
