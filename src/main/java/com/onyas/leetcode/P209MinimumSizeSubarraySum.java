package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/12
 * Time: 上午9:00
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * click to show more practice.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Two Pointers Binary Search
 * Hide Similar Problems (H) Minimum Window Substring (M) Maximum Size Subarray Sum Equals k
 */
public class P209MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int j = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                result = Math.min(result, j - i);
            }
            sum -= nums[i];
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
//        System.out.println(new P209MinimumSizeSubarraySum().minSubArrayLen(7, nums));
        System.out.println(new P209MinimumSizeSubarraySum().minSubArrayLen(15,new int[]{1,2,3,4,5}));

    }

}
