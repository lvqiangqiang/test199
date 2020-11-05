package com.kkgs.test.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: lvqiang
 * @Date: 2020/06/29/16:44
 * @Description:
 */
@Getter
@Setter
@ToString
public class Parent {


    @JSONField(name = "AGE")
    private Integer age;
    @JSONField(name = "NAME")
    private String name;
    /**
     * 性别
     */
    private Integer gender;
}
