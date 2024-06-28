package com.pn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;

/**
 * 角色表的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    private int roleId;//角色id
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fff\\w]{2,20}$")
    private String roleName;//角色名称
    @Pattern(regexp = "^[.]{0,500}$")
    private String roleDesc;//角色描述
    @NotNull
    @Pattern(regexp = "^[\\w]{4,20}$")
    private String roleCode;//角色标识

    private String roleState;//角色状态
    @NotNull
    private int createBy;//创建角色的用户id

    //json转换的日期格式
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    private int updateBy;//修改角色的用户id
    private Date updateTime;//修改时间
    private String getCode;//追加的属性--创建角色的用户的用户名
}
