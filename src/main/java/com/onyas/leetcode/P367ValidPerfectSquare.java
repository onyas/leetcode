package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/29
 * Time: 上午9:43
 * <p/>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Returns: True
 * Example 2:
 * Input: 14
 * Returns: False
 * Credits:
 * Special thanks to @elmirap for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Math
 * Hide Similar Problems (M) Sqrt(x)
 */
public class P367ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 0) {
            return true;
        }
        int result = mySqrt(num);
        return result != 0;
    }

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 1;
        int right = x / 2 + 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if ((x / middle == middle) && (x % middle == 0)) {
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
        System.out.println(new P367ValidPerfectSquare().isPerfectSquare(9));
        System.out.println(new P367ValidPerfectSquare().isPerfectSquare(5));
        System.out.println(new P367ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new P367ValidPerfectSquare().isPerfectSquare(14));
    }

}
