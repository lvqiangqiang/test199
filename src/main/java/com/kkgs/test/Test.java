package com.kkgs.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kkgs.test.po.ListNode;
import com.kkgs.test.po.Parent;
import com.sun.org.apache.xpath.internal.operations.String;
import utils.DesensitizationUtils;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: lvqiang
 * @Date: 2020/07/01/14:11
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
//        String phone = "18166040161";
//        String center = DesensitizationUtils.center(phone, 3, 4);
//        System.out.println(center);
    }

    /**
     * 配置文件读取方式
     */
    @org.junit.Test
    public void readConfigByResourceTest() throws IOException {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("h5-coupon-config.properties");
        java.lang.String collect = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    @org.junit.Test
    public void readConfigByFileTest() throws IOException {
//        InputStream fileInputStream = new FileInputStream(new File("h5-coupon-config.properties"));
//        java.lang.String collect = new BufferedReader(new InputStreamReader(fileInputStream)).lines().collect(Collectors.joining("\n"));
//        System.out.println(collect);

        File file = new File("");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }


    @org.junit.Test
    public void bigDTest() {
        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal);
    }


    @org.junit.Test
    public void JSONFileAnnotationTest() {
        Parent parent = new Parent();
        parent.setGender(1);
        parent.setAge(22);
        parent.setName("TOM");
        java.lang.String string = JSON.toJSONString(parent);
        System.out.println("parent通过JSON转换后：" + string);
        Parent t = JSONObject.toJavaObject(JSONObject.parseObject(string), Parent.class);
        System.out.println(t);

    }


    public void booleanTest(){
        Boolean aBoolean = null;
        System.out.println(aBoolean);
    }

    @org.junit.Test
    public void localTimeCaculateTest(){
        LocalTime dateStart = LocalTime.of(0, 0, 0);
        LocalTime now = LocalTime.now();
        Date date = new Date();
        System.out.println(now.toSecondOfDay());
        System.out.println(dateStart.toSecondOfDay());
        System.out.println(now.toSecondOfDay() - dateStart.toSecondOfDay());
    }



}
