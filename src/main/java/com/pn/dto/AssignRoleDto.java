package com.pn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 接收给用户分配角色前端传递的数据的Dto类:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssignRoleDto {
    @NotNull
    //接收请求参数userId -- 用户id
    private Integer userId;

    //接收请求参数roleCheckList -- 给用户分配的所有角色名
    private List<String> roleCheckList;
}
