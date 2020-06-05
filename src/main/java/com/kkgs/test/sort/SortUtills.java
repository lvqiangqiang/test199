package com.kkgs.test.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/26/15:32
 * @Description: 排序算法
 */
public class SortUtills {
    public static final Logger logger = LoggerFactory.getLogger(SortUtills.class);

    /**
     * 冒泡排序算法
     *
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        //优化点二：设置最后一次移动位置。当末尾数组已经是有序 ，此时只需要比较前部分数据即可，设置末尾比较标志。
        int len = arr.length - 1;
        int tempPosit = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //优化点1：设置标志位， 当标志位未变动过(说明数组已经是顺序的了)，可直接跳出循环
            int flag = 0;
            for (int j = 1; j < len; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    flag = 1;
                    tempPosit = j;
                }
                logger.info("第{}遍，第{}趟结果：{}", i, j, arr);
            }
            len = tempPosit;
            if (flag == 0) {
                return;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr 待排序数组
     */
    public static void selectSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 插入排序
     *
     * @param arr 待排序数组
     */
    public static void insertSotr(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr   待排序数组
     * @param begin 起始值
     * @param end   末尾值
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int low = begin;
        int high = end;
        int index = begin;
        int temp = arr[low];
        while (high > low) {
            //开始比较右侧值
            while ((high > low) && (temp < arr[high])) {
                high--;
            }
            if (temp > arr[high]) {
                arr[low] = arr[high];
                index = high;
                low++;
            }
            //开始比较左侧值
            while ((high > low) && (temp > arr[low])) {
                low++;
            }
            if (temp < arr[low]) {
                arr[high] = arr[low];
                index = low;
                high--;
            }
        }
        arr[index] = temp;
        quickSort(arr, begin, index - 1);
        quickSort(arr, index + 1, end);
    }

    /**
     * 希尔排序
     *
     * @param arr        待排序数组
     * @param increments 增量
     */
    public static void shellSort(int[] arr, int[] increments) {
        int increment = 0;
        for (int i = 0; i < increments.length; i++) {
            increment = increments[i];
            for (int j = 0; j < increment; j++) {
                for (int k = j + increment; k < arr.length - increment + j; k += increment) {
                    int index = k;
                    int temp = arr[index];
                    while (index > j && temp < arr[index - increment]) {
                        arr[index] = arr[index - increment];
                        index -= increment;
                    }
                    arr[index] = temp;
                }
            }
        }
    }

    /**
     *  归并排序
     * @param arr 待排序数组
     * @return  排序结果
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        int[] result = merge(left, right);
        return result;
    }

    public static int[] merge(int[] left, int[] right) {
        List<Integer> list = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (left.length > leftIndex && right.length > rightIndex) {
            if (left[leftIndex] < right[rightIndex]) {
                list.add(left[leftIndex]);
                leftIndex++;
            } else {
                list.add(right[rightIndex]);
                rightIndex++;
            }
        }
        if (left.length != leftIndex) {
            for (int i = leftIndex; i < left.length; i++) {
                list.add(left[i]);
            }
        } else {
            for (int i = rightIndex; i < right.length; i++) {
                list.add(right[i]);
        }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


}