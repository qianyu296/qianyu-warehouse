package com.pn.service.impl;

import com.pn.dto.BrandAddDTO;
import com.pn.dto.BrandUpdateDTO;
import com.pn.entity.Brand;
import com.pn.entity.Result;
import com.pn.mapper.BrandMapper;
import com.pn.page.Page;
import com.pn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//指定缓存的名称即键的前缀,一般是@CacheConfig标注的类的全类名
@CacheConfig(cacheNames = "com.pn.service.impl.BrandServiceImpl")
@Service
public class BrandServiceImpl implements BrandService {

    //注入BrandMapper
    @Autowired
    private BrandMapper brandMapper;

    /*
      查询所有品牌的业务方法
     */
    //对查询到的所有品牌进行缓存,缓存到redis的键为all:brand
    @Cacheable(key = "'all:brand'")
    @Override
    public List<Brand> queryAllBrand() {
        //查询所有品牌
        return brandMapper.findAllBrand();
    }

    @Override
    public Page getBrandPage(Page page, Brand brand) {
        Integer i = selectBrandCount(page, brand);
        List<Brand> brands = brandMapper.selectBrandPage(page, brand);
        page.setTotalNum(i);
        page.setResultList(brands);
        return page;
    }

    @Override
    public Result brandAdd(BrandAddDTO brand) {
        Integer i = brandMapper.brandAdd(brand);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "新增品牌失败");
        }
        return Result.ok("新增供应商成功");
    }

    @Override
    public Result brandDelete(Integer brandId) {
        Integer i = brandMapper.brandDelete(brandId);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "删除品牌失败");
        }
        return Result.ok("删除品牌成功");
    }

    @Override
    public Result brandUpdate(BrandUpdateDTO brandUpdateDTO) {
        Integer i = brandMapper.brandUpdate(brandUpdateDTO);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "修改品牌失败");
        }
        return Result.ok("修改品牌成功");
    }

    @Override
    public Integer selectBrandCount(Page page, Brand brand) {
        return brandMapper.selectBrandCount(page, brand);
    }
}
