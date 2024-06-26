package com.pn.mapper;

import com.pn.entity.Statistics;
import com.pn.vo.StorageVO;

import java.util.List;

public interface StatisticsMapper {

    //统计各个仓库商品库存数量的方法
    public List<Statistics> statisticsStoreInvent();
    // 获取采购占比方法
    public List<Statistics> getPurchase();
    // 获取仓库存储走势方法
    public List<StorageVO> getStorage();
    public Long getInNum();
    public Long getOutNum();
    public Long getBuyNum();
    public Long getInStorage();
    public Long getOutStorage();
}
