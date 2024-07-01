package com.pn.mapper;

import com.pn.dto.BrandAddDTO;
import com.pn.dto.BrandUpdateDTO;
import com.pn.dto.UnitAddDTO;
import com.pn.dto.UnitUpdateDTO;
import com.pn.entity.Brand;
import com.pn.entity.Unit;
import com.pn.page.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UnitMapper {

    //查询所有单位的方法
    public List<Unit> findAllUnit();
    @Insert("insert into unit(unit_name,unit_desc) values(#{unitName},#{unitDesc})")
    public Integer unitAdd(UnitAddDTO unit);
    public List<Unit> selectUnitPage(@Param("page") Page page, @Param("unit") Unit unit);
    @Delete("delete from unit where unit_id = #{unitId}")
    public Integer unitDelete(Integer unitId);
    @Update("update unit set unit_name = #{unitName},unit_desc = #{unitDesc} where unit_id = #{unitId}")
    public Integer unitUpdate(UnitUpdateDTO unit);
    public Integer selectUnitCount(@Param("page") Page page, @Param("unit") Unit unit);
}
