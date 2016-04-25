package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/23
 * Time: 下午2:59
 * <p/>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class P303RangeSumQuery {

    private int[] sum;

    public P303RangeSumQuery(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null) {
            return 0;
        }
        if (i >= sum.length || j >= sum.length || i > j) {
            return 0;
        } else if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }

    public static void main(String[] args) {
        P303RangeSumQuery p303RangeSumQuery = new P303RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(p303RangeSumQuery.sumRange(0, 2));
        System.out.println(p303RangeSumQuery.sumRange(2, 5));
        System.out.println(p303RangeSumQuery.sumRange(0, 5));
    }
}
