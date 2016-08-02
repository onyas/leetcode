package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/27
 * Time: 上午8:55
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math Heap
 * Hide Similar Problems (M) Ugly Number II
 */
public class P313SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] times = new int[primes.length];
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * result[times[j]]);
            }
            result[i] = min;

            for (int j = 0; j < primes.length; j++) {
                if (min == (primes[j] * result[times[j]])) {
                    times[j]++;
                }
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P313SuperUglyNumber().nthSuperUglyNumber(1, new int[]{2, 3, 5}));
        System.out.println(new P313SuperUglyNumber().nthSuperUglyNumber(2, new int[]{2, 3, 5}));
        System.out.println(new P313SuperUglyNumber().nthSuperUglyNumber(3, new int[]{2, 3, 5}));
        System.out.println(new P313SuperUglyNumber().nthSuperUglyNumber(10, new int[]{2, 3, 5}));
    }
}
