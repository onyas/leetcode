package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/29
 * Time: 上午9:26
 * <p/>
 * Implement pow(x, n).
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Math
 * Hide Similar Problems (M) Sqrt(x)
 */
public class P050Powxn {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, n);
        } else {
            return pow(x, n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = pow(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P050Powxn().myPow(2, 3));
    }
}
