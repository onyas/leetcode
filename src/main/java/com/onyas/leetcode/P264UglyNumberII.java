package com.onyas.leetcode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/25
 * Time: 上午9:27
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * Hint:
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.Show More Hint
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Dynamic Programming Heap Math
 * Hide Similar Problems (H) Merge k Sorted Lists (E) Count Primes (E) Ugly Number (M) Perfect Squares (M) Super Ugly Number
 */
public class P264UglyNumberII {

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        ArrayList<Integer> datas = new ArrayList<Integer>();
        datas.add(1);
        int i = 0, j = 0, k = 0;
        while (datas.size() < n) {
            int m2 = datas.get(i) * 2;
            int m3 = datas.get(j) * 3;
            int m5 = datas.get(k) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            datas.add(min);

            if (min == m2) {
                i++;
            }
            if (min == m3) {
                j++;
            }
            if (min == m5) {
                k++;
            }
        }
        return datas.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P264UglyNumberII().nthUglyNumber(1));
        System.out.println(new P264UglyNumberII().nthUglyNumber(2));
        System.out.println(new P264UglyNumberII().nthUglyNumber(3));
        System.out.println(new P264UglyNumberII().nthUglyNumber(10));
    }
}
