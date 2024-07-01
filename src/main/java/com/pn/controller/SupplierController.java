package com.pn.controller;

import com.pn.dto.SupplierAddDTO;
import com.pn.dto.SupplierUpdateDTO;
import com.pn.entity.Result;
import com.pn.entity.Supplier;
import com.pn.mapper.SupplierMapper;
import com.pn.page.Page;
import com.pn.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierMapper supplierMapper;
    @GetMapping("/supplier-page-list")
    public Result supplierPageList(Page page, Supplier supplier){
        // System.out.println(supplier.toString());
        page = supplierService.querySupplyPage(page, supplier);
        return Result.ok(page);
    }
    @DeleteMapping("/supplier-delete/{supplierId}")
    public Result supplierDelete(@PathVariable Integer supplierId){
         return supplierService.supplierDelete(supplierId);
    }
    @PostMapping("/supplier-add")
    public Result supplierAdd(@Validated @RequestBody SupplierAddDTO supplier){
        Result result = supplierService.supplierAdd(supplier);
        return result;
    }
    @GetMapping("/supplier-num-check")
    public Result supplierNumCheck(String supplierNum){
        Integer count = supplierMapper.supplierNumCheck(supplierNum);
        return Result.ok(count == 0);
    }
    @PutMapping("/supplier-update")
    public Result supplierUpdate(@Validated @RequestBody SupplierUpdateDTO supplierUpdateDTO){
        Result result = supplierService.supplierUpdate(supplierUpdateDTO);
        return result;
    }
    @GetMapping("/exportTable")
    public Result exportTable(Page page, Supplier supplier){
        page = supplierService.querySupplyPage(page,supplier);
        List<?> list = page.getResultList();
        return Result.ok(list);
    }
}
