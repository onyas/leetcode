package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/28
 * Time: 上午9:41
 * <p/>
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * Subscribe to see which companies asked this question
 * Hide Tags Math Binary Search
 * <p/>
 * This problem can be solved based on the fact that any number can be converted to the format of the following:
 * num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n   Ologn
 */
public class P029DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long pDividend = Math.abs((long) dividend);
        long pDivisor = Math.abs((long) divisor);
        int result = 0;
        while (pDividend >= pDivisor) {
            int sshift = 0;
            while (pDividend >= (pDivisor << sshift)) {
                sshift++;
            }
            result += 1 << (sshift - 1);
            pDividend -= (pDivisor << (sshift - 1));
        }

        //异或，相同为0，不同为1
        return (dividend > 0 ^ divisor > 0) ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new P029DivideTwoIntegers().divide(10, 3));
        System.out.println(new P029DivideTwoIntegers().divide(1, 1));
    }
}
