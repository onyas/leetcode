package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/22
 * Time: 上午9:36
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math
 * Hide Similar Problems (H) Number of Digit One
 */
public class P172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P172FactorialTrailingZeroes().trailingZeroes(25));
    }
}
