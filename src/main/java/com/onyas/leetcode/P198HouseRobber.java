package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/12
 * Time: 上午8:49
 * <p/>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
 * you can rob tonight without alerting the police.
 * <p/>
 * 不能打劫相邻的两家否则会触发警报。
 * 显然这是一道DP题，状态转移方程 dp[i] = max(nums[i] + dp[i-2], dp[i-1])
 * <p/>
 * 这样做的时间复杂度O(n),空间复杂度O(n)
 */
public class P198HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }

        int result[] = new int[n];
        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            result[i] = Math.max(result[i-1],result[i-2]+nums[i]);
        }

        return result[n-1];
    }

    public static void main(String[] args){

        System.out.println(new P198HouseRobber().rob(new int[]{1,3,5}));
    }

}
