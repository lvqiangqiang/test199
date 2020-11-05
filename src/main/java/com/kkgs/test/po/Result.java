package com.kkgs.test.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: lvqiang
 * @Date: 2020/06/09/18:48
 * @Description:
 */
@Getter
@Setter
@ToString
public class Result implements Serializable {


    private Boolean isSuccess;

    private String msg;

    private Object object;

}
