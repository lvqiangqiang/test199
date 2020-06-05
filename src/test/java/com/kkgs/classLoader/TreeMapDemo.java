package com.kkgs.classLoader;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/19/15:13
 * @Description:
 */
public class TreeMapDemo {

    @Test
    public void Test() {

        Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                }
                return -1;
            }
        });
//        Map<Integer, Integer> map = new TreeMap<>();
//        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");

        for (Integer key: map.keySet()){
            System.out.println(map.get(key));
        }

        for (Map.Entry entry : map.entrySet()){
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }


    }

}
