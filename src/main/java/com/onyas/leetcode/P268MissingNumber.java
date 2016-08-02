package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/27
 * Time: 上午9:16
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Math Bit Manipulation
 * Hide Similar Problems (H) First Missing Positive (M) Single Number (H) Find the Duplicate Number
 * 第一种方法可以用等差数列来解决，就是先求出前n项和,然后在求出nums的和，相减就是少的那个数
 * 第二种方法可以用异或来解决，用前n个数分别对nums求异或，相同的异或结果就为0，最后剩下的就是结果
 */
public class P268MissingNumber {

    public int missingNumber(int[] nums) {
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            missing ^= (i + 1) ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args){
        System.out.println(new P268MissingNumber().missingNumber(new int[]{0,1,3}));
        System.out.println(new P268MissingNumber().missingNumber(new int[]{0,1,2,3,5}));
        System.out.println(new P268MissingNumber().missingNumber(new int[]{0,1,2,3,4,5,7}));
    }
}
