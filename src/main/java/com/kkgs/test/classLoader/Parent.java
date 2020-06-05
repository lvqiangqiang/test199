package com.kkgs.test.classLoader;

import com.univocity.parsers.annotations.Trim;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/18/15:56
 * @Description:
 */
public class Parent implements Cloneable {
    public static Integer age = 1;

    public String name;


    public Parent(String name) {
        this.name = name;
    }

    public Parent() {
        System.out.println("parent constructor....");
    }

    public static Integer getAge() {
        return age;
    }

    @Deprecated
    public static void setAge(Integer age) {
        Parent.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
