package com.onyas.leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/26
 * Time: 上午9:01
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Dynamic Programming Breadth-first Search Math
 * Hide Similar Problems (E) Count Primes (M) Ugly Number II
 * <p/>
 * 如果一个数x可以表示为一个任意数a加上一个平方数bｘb，也就是x=a+bｘb，那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1（因为b*b已经是平方数了）。
 */
public class P279PerfectSquares {

    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        int dp[] = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= max; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                } else if (i > j * j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new P279PerfectSquares().numSquares(12));
        System.out.println(new P279PerfectSquares().numSquares(13));
    }
}
