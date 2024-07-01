package com.pn.service;

import com.pn.dto.BrandAddDTO;
import com.pn.dto.BrandUpdateDTO;
import com.pn.entity.Brand;
import com.pn.entity.Result;
import com.pn.page.Page;

import java.util.List;

public interface BrandService {

    //查询所有品牌的业务方法
    public List<Brand> queryAllBrand();
    public Page getBrandPage(Page page, Brand brand);
    public Result brandAdd(BrandAddDTO brand);
    public Result brandDelete(Integer brandId);
    public Result brandUpdate(BrandUpdateDTO brandUpdateDTO);
}
