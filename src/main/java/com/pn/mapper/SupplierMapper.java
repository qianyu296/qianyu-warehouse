package com.pn.mapper;

import com.pn.dto.SupplierAddDTO;
import com.pn.dto.SupplierUpdateDTO;
import com.pn.entity.Store;
import com.pn.entity.Supplier;
import com.pn.page.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SupplierMapper {

    //查询所有供应商的方法
    public List<Supplier> findAllSupply();
    public List<Store> selectSupplyPage(@Param("page") Page page, @Param("supplier") Supplier supplier);
    @Update("update supplier set is_delete = 1 where supplier_id = #{supplierId}")
    public Integer deleteSupplier(Integer supplierId);
    @Select("select count(*) from buy_list where supply_id = #{supplierId} and is_in = 1")
    public Integer selectSupplierIsBuy(Integer supplierId);
    @Insert("insert into supplier(supplier_num,supplier_name,supplier_introduce,concat,address,phone) " +
            "values(#{supplierNum},#{supplierName},#{supplierIntroduce},#{concat},#{address},#{phone})")
    public Integer supplierAdd(SupplierAddDTO supplier);
    @Select("select count(*) from supplier where supplier_num = #{supplierNum}")
    public Integer supplierNumCheck(String supplierNum);
    @Update("update supplier set supplier_name = #{supplierName},supplier_introduce = #{supplierIntroduce},concat = #{concat}," +
            "phone = #{phone},address = #{address} where supplier_id = #{supplierId} and is_delete = 0")
    public Integer supplierUpdate(SupplierUpdateDTO supplier);
}
