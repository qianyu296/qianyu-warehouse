package com.pn.service.impl;

import com.pn.entity.Statistics;
import com.pn.mapper.StatisticsMapper;
import com.pn.service.StatisticsService;
import com.pn.vo.InOutStorageVO;
import com.pn.vo.RealTimeDataVO;
import com.pn.vo.StorageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    //注入StatisticsMapper
    @Autowired
    private StatisticsMapper statisticsMapper;

    //统计各个仓库商品库存数量的业务方法
    @Override
    public List<Statistics> statisticsStoreInvent() {
        // 获取当前时间
        String now = LocalDateTime.now().toString();
        String data = now.split("T")[0];
        // 获取存储走势

        return statisticsMapper.statisticsStoreInvent();
    }

    @Override
    public List<Statistics> getPurchase() {
        List<Statistics> purchase = statisticsMapper.getPurchase();
        return purchase;
    }

    @Override
    public List<StorageVO> getStorage() {
        return statisticsMapper.getStorage();
    }
    /**
     * 获取今日实时数据
     * */
    @Override
    public RealTimeDataVO getRealTimeData() {
        // 获取入库数量
        Long inNum = statisticsMapper.getInNum();
        // 获取出库数量
        Long outNum = statisticsMapper.getOutNum();
        // 获取采购数量
        Long buyNum = statisticsMapper.getBuyNum();
        RealTimeDataVO realTimeData = new RealTimeDataVO();
        if(inNum != null){
            realTimeData.setInNum(inNum);
        }
        if(outNum != null){
            realTimeData.setOutNum(outNum);
        }
        if(buyNum != null){
            realTimeData.setBuyNum(buyNum);
        }
        return realTimeData;
    }
    /**
     * 获取今年每月份的出入库信息
     * */
    @Override
    public List<InOutStorageVO> getInOutStorage() {
        // 获取入库数量
        Long inStorage = statisticsMapper.getInStorage();
        // 获取出库数量
        Long outStorage = statisticsMapper.getOutStorage();

        return null;
    }
}
