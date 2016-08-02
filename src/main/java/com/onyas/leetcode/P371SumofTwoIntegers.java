package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/8/2
 * Time: 上午8:48
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * Credits:
 * Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Bit Manipulation
 * Hide Similar Problems (M) Add Two Numbers
 */
public class P371SumofTwoIntegers {

    public int getSum(int a, int b) {
        while (a != 0) {
            int x = a ^ b;
            a = (a & b) << 1;
            b = x;
        }
        return b;
    }

    public static void main(String[] args){
        System.out.println(new P371SumofTwoIntegers().getSum(3,5));
        System.out.println(new P371SumofTwoIntegers().getSum(1,2));
        System.out.println(new P371SumofTwoIntegers().getSum(3,6));
    }

}
