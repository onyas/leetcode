package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/28
 * Time: 下午7:17
 * <p/>
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Math
 * Hide Similar Problems (M) Pow(x, n) (M) Valid Perfect Square
 *
 * 二分法解决开方的问题
 */
public class P069Sqrtx {

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 1;
        int right = x / 2 + 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (x / middle >= middle && (x / (middle + 1)) < (middle + 1)) {
                return middle;
            }

            if (x / middle < middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P069Sqrtx().mySqrt(4));
        System.out.println(new P069Sqrtx().mySqrt(10));
        System.out.println(new P069Sqrtx().mySqrt(1));
        System.out.println(new P069Sqrtx().mySqrt(8));
    }

}
