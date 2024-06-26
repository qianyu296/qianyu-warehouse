package com.pn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageVO {
    private Integer year;
    private Integer month;
    private Integer storeId;
    private String storeName;
    private Long total;
}
