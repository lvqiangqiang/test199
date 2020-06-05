package com.kkgs.test.sort;

import java.io.IOException;
import java.util.Scanner;


/**
 * @Auther: lvqiang
 * @Date: 2020/05/26/15:03
 * @Description: 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int search;
        int begin = 0;
        int end = arr.length-1;
        Scanner scanner = new Scanner(System.in);
        search = scanner.nextInt();
        while (end>begin){
            int index = (end+begin)/2;
            if (arr[index] ==  search){
                System.out.println("找到对应值："+search);
                return;
            }
            if (arr[index] > search){
                end = index-1;
            }else{
                begin = index+1;
            }
        }
    }

}
