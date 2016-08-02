package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/27
 * Time: 上午9:22
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Subscribe to see which companies asked this question
 * Hide Tags Hash Table Bit Manipulation
 * Hide Similar Problems (M) Single Number II (M) Single Number III (M) Missing Number (H) Find the Duplicate Number
 * 除了一个数字外其它都出现两次，那么可以循环对所以数进行异或，最后结果就是那个单个数的
 */
public class P136SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(new P136SingleNumber().singleNumber(new int[]{1,1,2}));
        System.out.println(new P136SingleNumber().singleNumber(new int[]{2,1,2}));
        System.out.println(new P136SingleNumber().singleNumber(new int[]{3,3,2}));
        System.out.println(new P136SingleNumber().singleNumber(new int[]{3,3,5}));
    }
}
