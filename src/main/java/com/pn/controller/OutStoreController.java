package com.pn.controller;

import com.pn.dto.OutStoreAddDTO;
import com.pn.entity.OutStore;
import com.pn.entity.Result;
import com.pn.entity.Store;
import com.pn.page.Page;
import com.pn.service.OutStoreService;
import com.pn.service.StoreService;
import com.pn.utils.CurrentUser;
import com.pn.utils.TokenUtils;
import com.pn.utils.WarehouseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/outstore")
@RestController
public class OutStoreController {

    //注入OutStoreService
    @Autowired
    private OutStoreService outStoreService;

    //注入TokenUtils
    @Autowired
    private TokenUtils tokenUtils;

    //注入StoreService
    @Autowired
    private StoreService storeService;

    /**
     * 添加出库单的url接口/outstore/outstore-add
     *
     * @RequestBody OutStore outStore将添加的出库单信息的json数据封装到参数OutStore对象;
     * @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token
     * 将请求头Token的值即客户端归还的token赋值给参数变量token;
     */
    @RequestMapping("/outstore-add")
    public Result addOutStore(@Validated @RequestBody OutStoreAddDTO outStore,
                              @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token){

        //获取当前登录的用户
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id,即添加出库单的用户id
        int createBy = currentUser.getUserId();
        outStore.setCreateBy(createBy);

        //执行业务
        Result result = outStoreService.saveOutStore(outStore);

        //响应
        return result;
    }

    /**
     * 查询所有仓库的url接口/outstore/store-list
     */
    @RequestMapping("/store-list")
    public Result storeList(){
        //执行业务
        List<Store> storeList = storeService.queryAllStore();
        //响应
        return Result.ok(storeList);
    }

    /**
     * 分页查询出库单的url接口/outstore/outstore-page-list
     *
     * 参数Page对象用于接收请求参数页码pageNum、每页行数pageSize;
     * 参数OutStore对象用于接收请求参数仓库id storeId、商品名称productName、
     * 是否出库isOut、起止时间startTime和endTime;
     *
     * 返回值Result对象向客户端响应组装了所有分页信息的Page对象;
     */
    @RequestMapping("/outstore-page-list")
    public Result outStorePageList(Page page, OutStore outStore){
        //执行业务
        page = outStoreService.outStorePage(page, outStore);
        //响应
        return Result.ok(page);
    }

    /**
     * 确定出库的url接口/outstore/outstore-confirm
     * @param outStore
     * @return
     */
    @RequestMapping("/outstore-confirm")
    public Result confirmOutStore(@RequestBody OutStore outStore){
        //执行业务
        Result result = outStoreService.confirmOutStore(outStore);
        //响应
        return result;
    }
    /**
     * 导出出库列表数据
     * @param outStore,page
     * @return
     * */
    @GetMapping("/exportTable")
    public Result exportTable(Page page, OutStore outStore){
        page = outStoreService.outStorePage(page, outStore);
        List<?> list = page.getResultList();
        return Result.ok(list);
    }
}
