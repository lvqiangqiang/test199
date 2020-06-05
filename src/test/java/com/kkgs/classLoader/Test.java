package com.kkgs.classLoader;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kkgs.test.classLoader.Parent;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/18/15:58
 * @Description:
 */
@SuppressWarnings("AccessStaticViaInstance")
public class Test {


    Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void test() throws InterruptedException, ClassNotFoundException {
//        System.out.println(Parent.class);
//        Class<?> parent = ClassLoader.getSystemClassLoader().loadClass("com.kkgs.classLoader.Parent");
//        System.out.println(parent);
        Class<?> aClass = Class.forName("com.kkgs.classLoader.Parent");
        System.out.println(aClass.toString());
    }



    @org.junit.Test
    public void hashTest(){
//        Double i = Math.pow(2,0);
//        System.out.println(i);
//        int hashCode = i.hashCode();
//        System.out.println(hashCode);
//        System.out.println(hashCode^(hashCode>>>16));
        Map<Object, Object> map = new HashMap<>();
        map.put("aa","bb");
        map.put("bb",null);
        map.put("cc",null);
        map.put("dd",null);
        map.put("ee",null);
        map.put("ff",null);
        map.put("gg",null);
        map.put("hh",null);
        map.put("ii",null);
        System.out.println(map.get(null));
        try {
            map.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void test3() throws CloneNotSupportedException {
        Parent parent = new Parent();
        parent.setName("Tom");
        Parent clone = (Parent)parent.clone();
        String age = clone.getName();
        System.out.println(age);

    }

    @org.junit.Test
    public void test5() throws Exception {
        String standby1 = "2020-05-21 21:10:34 查询失败. result={\"data\":\",个体户全称不能以“公司”结尾，请检查后再试\",\"isSuccess\":\"T\"}";
        String infoTips = standby1.substring(standby1.indexOf("["), standby1.indexOf("}")+1);
//        InfoTips infoTips1 = JSON.parseObject(infoTips, InfoTips.class);
//        System.out.println(infoTips1.getData());

//        int data = infoTips.indexOf(":")+1;
//        int i = StringUtils.ordinalIndexOf(infoTips, ",", 2);
//        String substring = infoTips.substring(data, i).replaceAll(",","");
//        String[] split = infoTips.split(",");
//        String s = split[0];
//        String substring = s.substring(s.indexOf(":"), s.length());
        System.out.println(infoTips);
//        System.out.println(data);
//        System.out.println(i);
//        System.out.println(substring);
    }


    @org.junit.Test
    public void test13(){
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        System.out.println(integers);

        test12(integers);
        System.out.println(integers);
    }

    public void test12(List<?> list){
        Class<? extends List> listClass = list.getClass();
        Constructor<?>[] constructors = listClass.getConstructors();
        logger.error("1111{}",constructors);
    }

    @org.junit.Test
    public void test16(){
//        Map<String,String> map= new HashMap<>();
//        map.put("dataSign","11111111111");
//        for (Map.Entry<String, String> set:map.entrySet()){
//            System.out.println(set.getKey().equals("sign"));
//        }
////        new ConcurrentHashMap<>()
//        Map<String, String> map1 = Collections.synchronizedMap(map);

//        Hashtable<Object, Object> hashtable= new Hashtable<>();
//        hashtable.put(null,"111");
        Map<Object, Object> map= new ConcurrentHashMap<>();
        map.put(null,"11");



    }

    @org.junit.Test
    public void test19(){
        String str = "/u4fl8/u79c0";
        System.out.println(str);
    }



}
