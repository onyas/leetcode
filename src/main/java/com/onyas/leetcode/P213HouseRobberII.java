package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/12
 * Time: 上午9:07
 * <p/>
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not
 * get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of
 * the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob
 * tonight without alerting the police.
 * <p/>
 * This is an extension of House Robber. There are two cases here 1) 1st element is included and last is not included 2) 1st is not included
 * and last is included. Therefore, we can use the similar dynamic programming approach to scan the array twice and get the larger value.
 *
 * DP
 */
public class P213HouseRobberII {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        //include the first
        int result[] = new int[n + 1];
        result[0] = 0;
        result[1] = nums[0];
        for (int i = 2; i < n; i++) {
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i - 1]);
        }

        //not include the first
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Math.max(result[n - 1], dp[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new P213HouseRobberII().rob(new int[]{1, 3, 4, 5}));
    }
}
