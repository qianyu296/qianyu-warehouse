package com.pn.service;

import com.pn.dto.SupplierAddDTO;
import com.pn.dto.SupplierUpdateDTO;
import com.pn.entity.Result;
import com.pn.entity.Supplier;
import com.pn.page.Page;

import java.util.List;

public interface SupplierService {

    //查询所有供应商的业务方法
    public List<Supplier> queryAllSupply();
    public Page querySupplyPage(Page page, Supplier supplier);
    public Result supplierDelete(Integer supplierId);
    public Result supplierAdd(SupplierAddDTO supplier);
    public Result supplierUpdate(SupplierUpdateDTO supplierUpdateDTO);
}
