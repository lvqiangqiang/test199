package com.kkgs.test.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @auther: lvqiang
 * @date: 2020/10/26
 * @description:
 */
public class StreamTest {

    /**
     * 构造
     */
    @Test
    public void streamConstructTest() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

    }

    /**
     * Stream 支持的三种基本数据类型（IntStream、LongStream、DoubleStream）
     */
    @Test
    public void basicDateTypeConstructTest() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 32).forEach(System.out::println);
    }

    /**
     * 集合与stream
     */
    @Test
    public void collectionStreamTest(){
        Stream.of(new int[]{1,2,3});
    }
}
