package com.kkgs.test.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/26/15:35
 * @Description:
 */
public class SortUtillsTest {

    Logger logger = LoggerFactory.getLogger(SortUtillsTest.class);

    @Test
    public void bubbleSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90};
        SortUtills.bubbleSort(arr);
        logger.info("arr:{}", arr);
    }

    @Test
    public void selectSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90};
        SortUtills.selectSort(arr);
        logger.info("arr:{}", arr);
    }

    @Test
    public void insertSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90};
        SortUtills.insertSotr(arr);
        logger.info("arr:{}", arr);
    }

    @Test
    public void quickSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90};
        SortUtills.quickSort(arr, 0, arr.length - 1);
        logger.info("arr:{}", arr);
    }

    @Test
    public void shellSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90};
        int[] increments = {5, 1};
        SortUtills.shellSort(arr, increments);
        logger.info("arr:{}", arr);
    }

    @Test
    public void hellSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90};
        int[] increments = {4, 1};
        SortUtills.shellSort(arr, increments);
        logger.info("arr:{}", arr);
    }

    @Test
    public void mergeSortTest() {
        int[] arr = {56, 45, 13, 87, 100, 23, 55, 90,11};
        int[] ints = SortUtills.mergeSort(arr);
        logger.info("arr:{}", ints);
    }

}
