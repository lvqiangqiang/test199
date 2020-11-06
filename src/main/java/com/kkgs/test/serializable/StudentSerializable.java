package com.kkgs.test.serializable;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @auther: lvqiang
 * @date: 2020/11/04
 * @description:
 */
@Data
public class StudentSerializable implements Serializable{

    private static final long serialVersionUID = 1960895680483668967L;

    private String name;
    private String sno;
    private Integer age;

    private String password;


    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        // 默认反序列化函数
        objectInputStream.defaultReadObject();
        //手工检查 反序列化变量的合法性
        if (age < 0 || age > 100){
            throw new IllegalArgumentException("年龄必须在0到100之间！！！");
        }
        //test
    }
}
