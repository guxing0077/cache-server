package com.lee.service.impl;

import com.lee.entity.Dict;
import com.lee.mapper.DictMapper;
import com.lee.req.dict.DictReq;
import com.lee.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    @CachePut(value = "dict", key = "'dict_'+#dictReq.id")
    public Dict add(DictReq dictReq) {
        System.out.println("为id、key为:" + dictReq.getId() + "数据做了缓存");
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictReq, dict);
        dictMapper.insert(dict);
        return dict;
    }

    @Override
    @CachePut(value = "dict", key = "'dict_'+#dictReq.id")
    public Dict update(DictReq dictReq) {
        System.out.println("为id、key为:" + dictReq.getId() + "数据做了缓存");
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictReq, dict);
        dictMapper.updateById(dict);
        return dict;
    }

    @Override
    @Cacheable(value = "dict", key = "'dict_'+#id")
    public Dict findById(Integer id) {
        System.out.println("为id、key为:" + id + "数据做了缓存");
        return dictMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "dict", key = "'dict_'+#id")
    public void delete(Integer id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
        dictMapper.deleteById(id);
    }
}
