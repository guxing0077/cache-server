package com.lee.service.impl;

import com.lee.entity.Dict;
import com.lee.mapper.DictMapper;
import com.lee.req.dict.DictReq;
import com.lee.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public void add(DictReq dictReq) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictReq, dict);
        dictMapper.insert(dict);
    }

    @Override
    public void update(DictReq dictReq) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictReq, dict);
        dictMapper.updateById(dict);
    }

    @Override
    public Dict findById(Integer id) {
        return dictMapper.selectById(id);
    }

    @Override
    public void delete(Integer id) {
        dictMapper.deleteById(id);
    }
}
