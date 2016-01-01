package com.onyas.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <br>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <br>
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/4
 * Time: 下午12:16
 */
public class P016ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                if (diff == 0) {
                    return sum;
                }
                if (diff < closest) {
                    closest = diff;
                    result = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new P016ThreeSumClosest().threeSumClosest(new int[]{1, 1, 1, 2, 0}, 100));
    }

}
