package com.pn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InOutStorageVO {
    private Integer month;
    private Long InStorage;
    private Long OutStorage;
    private Long total;
}
