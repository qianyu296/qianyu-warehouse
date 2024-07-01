package com.pn.service;

import com.pn.dto.UnitAddDTO;
import com.pn.dto.UnitUpdateDTO;
import com.pn.entity.Unit;
import com.pn.entity.Result;
import com.pn.entity.Unit;
import com.pn.page.Page;

import java.util.List;

public interface UnitService {

    //查询所有单位的业务方法
    public List<Unit> queryAllUnit();
    public Page getUnitPage(Page page, Unit unit);
    public Result unitAdd(UnitAddDTO unit);
    public Result unitDelete(Integer unitId);
    public Result unitUpdate(UnitUpdateDTO unit);
    public Integer selectUnitCount(Page page, Unit unit);
}
