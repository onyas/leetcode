package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/26
 * Time: 上午9:12
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math
 * Hide Similar Problems (E) Power of Two (E) Power of Four
 * 一个基本的事实就是如果n是3的x次方，那么以3为低对数后一定是一个整数，否则不是
 */
public class P326PowerofThree {

    public boolean isPowerOfThree(int n) {
        double result = Math.log10(n) / Math.log10(3);
        return (result - (int) result) == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new P326PowerofThree().isPowerOfThree(12));
        System.out.println(new P326PowerofThree().isPowerOfThree(27));
    }

}
