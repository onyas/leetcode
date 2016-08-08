package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/8/4
 * Time: 上午9:04
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Greedy
 */
public class P055JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= max && nums[i] + i >= max) {//i小于等于max，代表在当前位置可以前进多少步
                max = nums[i] + i;
            }
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new P055JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new P055JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
