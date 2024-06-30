package com.pn.mapper;

import com.pn.entity.Store;
import com.pn.entity.Supplier;
import com.pn.page.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SupplierMapper {

    //查询所有供应商的方法
    public List<Supplier> findAllSupply();
    public List<Store> selectSupplyPage(@Param("page") Page page, @Param("supplier") Supplier supplier);
    @Delete("delete from supplier where supply_id = #{supplierId}")
    public Integer deleteSupplier(Integer supplierId);
    @Select("select count(*) from buy_list where supply_id = #{supplyId} and is_in = 1")
    public Integer selectSupplierIsBuy(Integer supplyId);
}
