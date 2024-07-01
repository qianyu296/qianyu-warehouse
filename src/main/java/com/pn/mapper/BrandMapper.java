package com.pn.mapper;

import com.pn.dto.BrandAddDTO;
import com.pn.dto.BrandUpdateDTO;
import com.pn.entity.Brand;
import com.pn.page.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BrandMapper {

    //查询所有品牌的方法
    public List<Brand> findAllBrand();
    @Insert("insert into brand(brand_name,brand_leter,brand_desc) values(#{brandName},#{brandLeter},#{brandDesc})")
    public Integer brandAdd(BrandAddDTO brandAddDTO);
    public List<Brand> selectBrandPage(@Param("page") Page page,@Param("brand") Brand brand);
    @Delete("delete from brand where brand_id = #{brandId}")
    public Integer brandDelete(Integer brandId);
    @Update("update brand set brand_name = #{brandName},brand_leter = #{brandLeter},brand_desc = #{brandDesc} where brand_id = #{brandId}")
    public Integer brandUpdate(BrandUpdateDTO brandUpdateDTO);
    public Integer selectBrandCount(@Param("page") Page page,@Param("brand") Brand brand);
}
