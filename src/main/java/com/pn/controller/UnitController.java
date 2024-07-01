package com.pn.controller;

import com.pn.dto.UnitAddDTO;
import com.pn.dto.UnitUpdateDTO;
import com.pn.entity.Unit;
import com.pn.entity.Result;
import com.pn.entity.Unit;
import com.pn.page.Page;
import com.pn.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;
    /**
     * 查询所有单位的url接口/unit/unit-list
     *
     * 返回值Result对象给客户端响应查询到的List<Unit>;
     */
    @GetMapping("/unit-list")
    public Result unitList(){
        //执行业务
        List<Unit> unitList = unitService.queryAllUnit();
        //响应
        return Result.ok(unitList);
    }
    /**
     * 分页获取品牌
     * @param unit page
     * @return
     *
     * */
    @GetMapping("/unit-page-list")
    public Result getUnitPage(Page page, Unit unit){
        System.out.println(unit.toString());
        System.out.println(page.toString());
        Page unitPage = unitService.getUnitPage(page, unit);
        return Result.ok(unitPage);
    }
    /**
     * 新增品牌
     * @param unitAddDTO
     * @return
     *
     * */
    @PostMapping("/unit-add")
    public Result unitAdd(@Validated @RequestBody UnitAddDTO unitAddDTO){
        Result result = unitService.unitAdd(unitAddDTO);
        return result;
    }
    /**
     * 删除品牌
     * @param unitId
     * @return
     *
     * */
    @DeleteMapping("/unit-delete/{unitId}")
    public Result unitDelete(@PathVariable Integer unitId){
        return unitService.unitDelete(unitId);
    }
    /**
     * 修改品牌
     * @param unitUpdateDTO
     * @return
     * */
    @PutMapping("/unit-update")
    public Result unitUpdate(@Validated @RequestBody UnitUpdateDTO unitUpdateDTO){
        return unitService.unitUpdate(unitUpdateDTO);
    }
    @GetMapping("/exportTable")
    public Result exportTable(Page page, Unit unit){
        page = unitService.getUnitPage(page, unit);
        List<?> list = page.getResultList();
        return Result.ok(list);
    }
}
