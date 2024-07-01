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
public class UnitAddDTO implements Serializable {

    private Integer unitId;//单位id
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fff]{1,10}$")
    private String unitName;//单位
    @Pattern(regexp = "^.{0,500}$")
    private String unitDesc;//单位描述
}
