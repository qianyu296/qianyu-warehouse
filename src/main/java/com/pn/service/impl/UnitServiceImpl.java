package com.pn.service.impl;

import com.pn.dto.UnitAddDTO;
import com.pn.dto.UnitUpdateDTO;
import com.pn.entity.Unit;
import com.pn.entity.Result;
import com.pn.entity.Unit;
import com.pn.mapper.UnitMapper;
import com.pn.page.Page;
import com.pn.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//指定缓存的名称即键的前缀,一般是@CacheConfig标注的类的全类名
@CacheConfig(cacheNames = "com.pn.service.impl.UnitServiceImpl")
@Service
public class UnitServiceImpl implements UnitService {

    //注入UnitMapper
    @Autowired
    private UnitMapper unitMapper;

    /*
      查询所有单位的业务方法
     */
    //对查询到的所有单位进行缓存,缓存到redis的键为all:unit
    @Cacheable(key = "'all:unit'")
    @Override
    public List<Unit> queryAllUnit() {
        //查询所有单位
        return unitMapper.findAllUnit();
    }
    @Override
    public Page getUnitPage(Page page, Unit unit) {
        Integer i = selectUnitCount(page, unit);
        List<Unit> units = unitMapper.selectUnitPage(page, unit);
        page.setTotalNum(i);
        page.setResultList(units);
        return page;
    }

    @Override
    public Result unitAdd(UnitAddDTO unit) {
        Integer i = unitMapper.unitAdd(unit);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "新增单位失败");
        }
        return Result.ok("新增单位成功");
    }


    @Override
    public Result unitDelete(Integer unitId) {
        Integer i = unitMapper.unitDelete(unitId);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "删除单位失败");
        }
        return Result.ok("删除单位成功");
    }

    @Override
    public Result unitUpdate(UnitUpdateDTO unit) {
        Integer i = unitMapper.unitUpdate(unit);
        if(i == 0){
            return Result.err(Result.CODE_ERR_SYS, "修改单位失败");
        }
        return Result.ok("修改单位成功");
    }

    @Override
    public Integer selectUnitCount(Page page, Unit unit) {
        return unitMapper.selectUnitCount(page, unit);
    }
}
