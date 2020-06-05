package com.kkgs.test.reflec;

import com.alibaba.fastjson.JSON;
import com.kkgs.test.classLoader.Parent;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/21/11:38
 * @Description: 通过放射创建对象方式
 */
public class ReflecCreateDemo {

    /**
     * 通过对象的getCLass方法
     */
    @Test
    public void test() {
        Parent parent = new Parent();
        Class<? extends Parent> clazz = parent.getClass();
        System.out.println(clazz);
    }

    /**
     * 通过类的class方法
     */
    @Test
    public void test2() {
        Class<Parent> clazz = Parent.class;
        System.out.println(clazz);
    }

    /**
     * 通过Class 的静态方法(推荐....安全性能好)
     */
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.kkgs.test.classLoader.Parent");
        System.out.println(clazz);
        System.out.println("-------------获取clazz的全部成员变量------------------------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        System.out.println("-------------获取clazz的全部方法------------------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
        System.out.println("-------------获取clazz的构造方法------------------------");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : declaredConstructors){
            System.out.println(constructor);
        }
    }

    /**
     * 通过class创建对象的几种方法
     */

    public void test4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.kkgs.test.classLoader.Parent");
        // 1. class 的newInstance（）
        Parent parent = (Parent)clazz.newInstance();
        // 2. 通过构造方法的 newInstance（）
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Parent parent2 = (Parent)declaredConstructor.newInstance();
    }


    /**
     * 反射对象调用方法
     */
    @Test
    public void test5() throws Exception{
        Class<?> clazz = Class.forName("com.kkgs.test.classLoader.Parent");

        Method getAge = clazz.getDeclaredMethod("getAge");
        Object invoke = getAge.invoke(clazz);
        System.out.println("修改前："+invoke);

        Method setAge = clazz.getDeclaredMethod("setAge",new Class[]{Integer.class});
        setAge.invoke(clazz,2);

        Method getAge2 = clazz.getDeclaredMethod("getAge");
        Object invoke2 = getAge2.invoke(clazz);
        System.out.println("修改后："+invoke2);

        Parent parent = new Parent();
    }

    /**
     * 获取注解
     */
    @Test
    public void test6() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.kkgs.test.classLoader.Parent");
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation: annotations){
            System.out.println(annotation);
        }
    }


}
