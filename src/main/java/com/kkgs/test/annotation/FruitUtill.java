package com.kkgs.test.annotation;

import java.lang.reflect.Field;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/21/20:49
 * @Description:
 */
public class FruitUtill {

    public static void getFruitInfo(Class<?> clazz){
        String strFruitProvider = "供应商信息";
        //通过反射获取注解处信息
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields){
            if (field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商编号：" + fruitProvider.id()+
                                    " 供应商名称：" + fruitProvider.name()+
                                    " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
