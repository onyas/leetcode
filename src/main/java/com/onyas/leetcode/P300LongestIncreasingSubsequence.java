package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/17
 * Time: 上午9:16
 * <p/>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * DP,
 *
 */
public class P300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int result[] = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = result[i] > result[j] + 1 ? result[i] : result[j] + 1;
                }
            }
            if(result[i]>max){
                max = result[i];
            }
        }
        return max;
    }


    public static void main(String[] args){
        System.out.println(new P300LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
