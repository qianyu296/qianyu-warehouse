package com.pn.mapper;

import com.pn.entity.Store;
import com.pn.entity.Supplier;
import com.pn.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {

    //查询所有供应商的方法
    public List<Supplier> findAllSupply();
    public List<Store> selectSupplyPage(@Param("page") Page page, @Param("supplier") Supplier supplier);
}
