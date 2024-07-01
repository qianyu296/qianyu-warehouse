package com.pn.service.impl;

import com.pn.dto.SupplierAddDTO;
import com.pn.dto.SupplierUpdateDTO;
import com.pn.entity.Result;
import com.pn.entity.Store;
import com.pn.entity.Supplier;
import com.pn.mapper.SupplierMapper;
import com.pn.page.Page;
import com.pn.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//指定缓存的名称即键的前缀,一般是@CacheConfig标注的类的全类名
@CacheConfig(cacheNames = "com.pn.service.impl.SupplyServiceImpl")
@Service
public class SupplierServiceImpl implements SupplierService {

    //注入SupplyMapper
    @Autowired
    private SupplierMapper supplierMapper;

    /*
      查询所有供应商的业务方法
     */
    //对查询到的所有供应商进行缓存,缓存到redis的键为all:supply
    @Cacheable(key = "'all:supplier'")
    @Override
    public List<Supplier> queryAllSupply() {
        //查询所有供应商
        return supplierMapper.findAllSupply();
    }

    @Override
    public Page querySupplyPage(Page page, Supplier supplier) {
        // 查询供应商总行数
        List<Supplier> allSupplier = supplierMapper.findAllSupply();
        int count = allSupplier.size();
        System.out.println(supplier.toString());
        List<Store> stores = supplierMapper.selectSupplyPage(page, supplier);
        page.setTotalNum(count);
        page.setResultList(stores);
        return page;
    }
    /**
     * 删除供应商
     * @param supplierId
     * @return Result
     * */
    @Override
    public Result supplierDelete(Integer supplierId) {
        // 首先判断该供应商是否有流转中单据，如果有，那么不删除，如果没有，那么删除
        Integer count = supplierMapper.selectSupplierIsBuy(supplierId);
        if(count == 0){
            supplierMapper.deleteSupplier(supplierId);
            return Result.ok("删除供应商成功");
        }
        return Result.err(Result.CODE_ERR_SYS,"该供应商存在流转中单据，无法删除！");
    }

    @Override
    public Result supplierAdd(SupplierAddDTO supplier) {
        // 首先判断供应商编号是否唯一
        Integer count = supplierMapper.supplierNumCheck(supplier.getSupplierNum());
        if(count != 0){
            return Result.err(Result.CODE_ERR_SYS, "该供应商编号已存在！");
        }
        Integer i = supplierMapper.supplierAdd(supplier);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "系统错误");
        }
        return Result.ok("添加供应商成功！");
    }

    @Override
    public Result supplierUpdate(SupplierUpdateDTO supplierUpdateDTO) {
        Integer count = supplierMapper.supplierUpdate(supplierUpdateDTO);
        if(count != 0){
            return Result.ok("修改供应商成功");
        }
        return Result.err(Result.CODE_ERR_SYS,"系统错误");
    }

}
