package com.kkgs.test.po;

import com.alibaba.fastjson.JSON;
import com.hstypay.sandbox.support.BeanConvertHelper;
import com.univocity.parsers.common.beans.BeanHelper;
import org.springframework.util.ClassUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.hstypay.sandbox.support.BeanConvertHelper.*;

/**
 * @Auther: lvqiang
 * @Date: 2020/06/29/16:45
 * @Description:
 */
public class Test {

    @org.junit.Test
    public void test1() {

        Parent parent = new Parent();
        parent.setAge(1);
        parent.setName("parent");
        parent.setGender(1);
        Son son = new Son();
        copyProperties(parent, son);
        son.setAge(999);
        System.out.println(son);

    }


    @org.junit.Test
    public void bigDecimalTest() {
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal);
    }

    @org.junit.Test
    public void exceptiontest2() throws Exception {
        Parent parent = new Parent();

        String packageName = ClassUtils.getPackageName(parent.getClass());
        String shortName = ClassUtils.getShortName(parent.getClass());
        System.out.println(packageName);
        System.out.println(shortName);
    }


    @org.junit.Test
    public void lengthOfLongestSubstring() {
        String s = "dvdf";
        int maxLength = 0;
        String temp = "";
        char[] c = s.toCharArray();
        System.out.println(JSON.toJSONString(c));
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if (!temp.contains(c[i] + "")) {
                    temp += c[i];
                    continue;
                }
                if (temp.length() > maxLength) {
                    maxLength = temp.length();
                }
                j = i - 1;
                temp = "";
                break;
            }
        }
        System.out.println(maxLength > temp.length() ? maxLength : temp.length());
    }


    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxLength = 0, repeatPos = 0;
        for (int end = 0; end < s.length(); end++) {
            repeatPos = s.indexOf(s.charAt(end), start);
            if (end != repeatPos && start <= repeatPos) {
                start = repeatPos + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i), flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

    @org.junit.Test
    public void test() {
        int abba = lengthOfLongestSubstring("abcab");
        System.out.println(abba);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length, nums1Index = 0;
        int nums2Length = nums2.length, nums2Index = 0;
        int totalLength = nums1Length + nums2Length;
        int[] sortedNums = new int[totalLength];
        //将两个数组 组成一个有序数组
        for (int i = 0; i < totalLength; i++) {
            //若数组 nums1 到了结尾处，则直接nums2数组剩余部分全部填装入有序数组
            if (nums1Index == nums1Length) {
                sortedNums[i] = nums2[nums2Index++];
                continue;
            }
            //若数组 nums2 到了结尾处，则直接nums1数组剩余部分全部填装入有序数组
            if (nums2Index == nums2Length) {
                sortedNums[i] = nums1[nums1Index++];
                continue;
            }

            //比对 nums1与nums2 中值大小，较小值优先填装入有序数组
            if (nums1[nums1Index] < nums2[nums2Index]) {
                sortedNums[i] = nums1[nums1Index];
                nums1Index++;
            } else {
                sortedNums[i] = nums2[nums2Index];
                nums2Index++;
            }
        }
        if (totalLength % 2 == 0) {
            return (sortedNums[totalLength / 2] + sortedNums[(totalLength / 2) - 1]) / 2;
        }
        return sortedNums[totalLength / 2];
    }


    @org.junit.Test
    public void findMedianSortedArraysTest() {
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {4, 5, 6};
        double medianSortedArrays = findMedianSortedArrays(ints1, ints2);
        System.out.println(medianSortedArrays);
    }


    //暴力枚举
    public String longestPalindrome(String s) {
        String longestStr = "";
        if (s.length() == 1){
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String str = s.substring(i, j);
                if (isPalindrome(str)) {
                    longestStr = str.length() > longestStr.length() ? str : longestStr;
                }
            }
        }
        return longestStr;
    }

    public boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    @org.junit.Test
    public void longestPalindromeTest() {
        String str = longestPalindrome("cbbd");
        System.out.println(str);
    }

}
