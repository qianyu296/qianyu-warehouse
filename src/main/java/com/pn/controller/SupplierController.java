package com.pn.controller;

import com.pn.entity.Result;
import com.pn.entity.Supplier;
import com.pn.page.Page;
import com.pn.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @GetMapping("/supplier-page-list")
    public Result supplierPageList(Page page, Supplier supplier){
        // System.out.println(supplier.toString());
        page = supplierService.querySupplyPage(page, supplier);
        return Result.ok(page);
    };
}
