package com.kkgs.test.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: lvqiang
 * @Date: 2020/07/15/14:42
 * @Description:
 */
@Getter
@Setter
@ToString
public class Son extends Parent{

    private Integer age;

    private String name;
}
