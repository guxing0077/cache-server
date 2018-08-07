package com.lee.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("t_dict")
public class Dict {

    private Integer id;
    private String key;
    private String value;
    private String remark;
}
