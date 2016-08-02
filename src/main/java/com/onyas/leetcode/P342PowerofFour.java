package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/26
 * Time: 上午9:20
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * Credits:
 * Special thanks to @yukuairoy for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Bit Manipulation
 * Hide Similar Problems (E) Power of Two (E) Power of Three
 */
public class P342PowerofFour {

    public boolean isPowerOfFour(int num) {
        double result = Math.log10(num) / Math.log10(4);
        return (result - (int) result) == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new P342PowerofFour().isPowerOfFour(16));
        System.out.println(new P342PowerofFour().isPowerOfFour(24));
    }

}
