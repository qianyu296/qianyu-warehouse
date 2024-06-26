package com.pn.service;

import com.pn.entity.Statistics;
import com.pn.vo.InOutStorageVO;
import com.pn.vo.RealTimeDataVO;
import com.pn.vo.StorageVO;

import java.util.List;

public interface StatisticsService {

    //统计各个仓库商品库存数量的业务方法
    public List<Statistics> statisticsStoreInvent();
    public List<Statistics> getPurchase();
    public List<StorageVO> getStorage();
    public RealTimeDataVO getRealTimeData();
    public List<InOutStorageVO> getInOutStorage();
}
