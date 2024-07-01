package com.pn.controller;

import com.pn.dto.BrandAddDTO;
import com.pn.dto.BrandUpdateDTO;
import com.pn.entity.Brand;
import com.pn.entity.Result;
import com.pn.page.Page;
import com.pn.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@Slf4j
public class BrandController {
    @Autowired
    private BrandService brandService;
    /**
     * 查询所有品牌的url接口/product/brand-list
     *
     * 返回值Result对象给客户端响应查询到的List<Brand>;
     */
    @GetMapping("/brand-list")
    public Result brandList(){
        //执行业务
        List<Brand> brandList = brandService.queryAllBrand();
        //响应
        return Result.ok(brandList);
    }
    /**
     * 分页获取品牌
     * @param brand page
     * @return
     *
     * */
    @GetMapping("/brand-page-list")
    public Result getBrandPage(Page page, Brand brand){
        System.out.println(brand.toString());
        System.out.println(page.toString());
        Page brandPage = brandService.getBrandPage(page, brand);
        return Result.ok(brandPage);
    }
    /**
     * 新增品牌
     * @param brandAddDTO
     * @return
     *
     * */
    @PostMapping("/brand-add")
    public Result brandAdd(@Validated @RequestBody BrandAddDTO brandAddDTO){
        Result result = brandService.brandAdd(brandAddDTO);
        return result;
    }
    /**
     * 删除品牌
     * @param brandId
     * @return
     *
     * */
    @DeleteMapping("/brand-delete/{brandId}")
    public Result brandDelete(@PathVariable Integer brandId){
        return brandService.brandDelete(brandId);
    }
    /**
     * 修改品牌
     * @param brandUpdateDTO
     * @return
     * */
    @PutMapping("/brand-update")
    public Result brandUpdate(@Validated @RequestBody BrandUpdateDTO brandUpdateDTO){
        return brandService.brandUpdate(brandUpdateDTO);
    }
}
