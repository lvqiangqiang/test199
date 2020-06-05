package com.kkgs.test.annotation;

import java.lang.annotation.*;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/21/15:05
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 商户编号
     */
    public int id() default 0;

    /**
     * 供应商名称
     */
    public String name() default "";

    /**
     * 供应商地址
     */
    public String address() default "";
}
