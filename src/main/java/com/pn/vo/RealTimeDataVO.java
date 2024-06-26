package com.pn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealTimeDataVO {
    private Long inNum = 0L;
    private Long outNum = 0L;
    private Long buyNum = 0L;
}
