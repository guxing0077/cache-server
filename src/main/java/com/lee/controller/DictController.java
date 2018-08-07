package com.lee.controller;

import com.lee.common.BaseController;
import com.lee.common.JsonRes;
import com.lee.entity.Dict;
import com.lee.req.dict.DictReq;
import com.lee.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "字典接口", description = "字典接口")
@RestController
@RequestMapping("dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @PostMapping("add")
    @ApiOperation(value = "添加字典", notes = "添加字典")
    public JsonRes add(@RequestBody DictReq dictReq){
        dictService.add(dictReq);
        return success();
    }

    @PostMapping("update")
    @ApiOperation(value = "修改接口", notes = "修改接口")
    public JsonRes update(@RequestBody DictReq dictReq){
        dictService.update(dictReq);
        return success();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "查询字典", notes = "查询字典")
    public JsonRes findById(@PathVariable("id") Integer id){
        Dict dict = dictService.findById(id);
        return success(dict);
    }

    @GetMapping("delete/{id}")
    @ApiOperation(value = "删除接口", notes = "删除接口")
    public JsonRes deleteById(@PathVariable("id") Integer id){
        dictService.delete(id);
        return success();
    }
}
