package com.pn.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseAddDTO {

    private Integer buyId;//采购单id
    @NotNull
    private Integer productId;//采购单采购的商品id
    @NotNull
    private Integer storeId;//采购单采购的商品所在仓库id
    @NotNull
    @Min(1)
    @Max(9999999)
    private Integer buyNum;//预计采购的商品数量

    private Integer factBuyNum;//实际采购的商品数量

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buyTime;//采购时间
    @NotNull
    private Integer supplierId;//采购单采购的商品的供应商id
    // @NotNull
    // private Integer placeId;//采购单采购的商品的产地id
    @NotNull
    @Pattern(regexp = "^[\\u4e00-\\u9fffa-zA-Z]{1,20}$")
    private String buyUser;//采购人
    @NotNull
    @Pattern(regexp = "1[0-9]{10}")
    private String phone;//采购人联系电话

    private String isIn;//是否生成入库单,1.是,0.否

    //---------------追加属性---------------------------

    private String productName;//商品名称

    private String storeName;//仓库名称

    private String startTime;//搜索起始时间

    private String endTime;//搜索结束时间
}
