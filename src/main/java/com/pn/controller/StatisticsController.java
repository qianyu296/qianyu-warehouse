package com.pn.controller;

import com.pn.entity.Result;
import com.pn.entity.Statistics;
import com.pn.service.StatisticsService;
import com.pn.vo.RealTimeDataVO;
import com.pn.vo.StorageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/statistics")
@RestController
public class StatisticsController {

    //注入StatisticsService
    @Autowired
    private StatisticsService statisticsService;

    /**
     * 统计各个仓库商品库存数量的url接口/statistics/store-invent
     */
    @RequestMapping("/store-invent")
    public Result statisticsStoreInvent(){
        //执行业务
        List<Statistics> statisticsList = statisticsService.statisticsStoreInvent();
        //响应
        return Result.ok(statisticsList);
    }
    @GetMapping("/getPurchase")
    public Result staticGetPurchase(){
        List<Statistics> purchase = statisticsService.getPurchase();
        return Result.ok(purchase);
    }
    /**
     * 获取仓库存储走势接口
     *
     * */
    @GetMapping("/getStorage")
    public Result staticGetStorage(){
        List<StorageVO> storage = statisticsService.getStorage();
        return Result.ok(storage);
    }
    /**
     * 获取今日实时数据
     * */
    @GetMapping("/getRealTimeData")
    public Result staticGetRealTimeData(){
        RealTimeDataVO realTimeData = statisticsService.getRealTimeData();
        return Result.ok(realTimeData);
    }
    /**
     * 今年出入库信息
     * */
    @GetMapping("/InOutStorage")
    public Result staticGetInOutStorage(){
        return Result.ok();
    }
}
