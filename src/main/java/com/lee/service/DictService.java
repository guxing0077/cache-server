package com.lee.service;

import com.lee.entity.Dict;
import com.lee.req.dict.DictReq;

public interface DictService {

    Dict add(DictReq dictReq);

    Dict update(DictReq dictReq);

    Dict findById(Integer id);

    void delete(Integer id);
}
