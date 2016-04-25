package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/11
 * Time: 上午8:52
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 Example:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:

 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class P307NumArray {

    private int[] target;
    private int[] bit;

    public P307NumArray(int[] nums) {
        target = new int[nums.length + 1];
        bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int j = i + 1;
        int diff = val - target[i + 1];
        while (j < target.length) {
            bit[j] += diff;
            j += lowbit(j);
        }
        target[i + 1] = val;
    }

    int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }

    public int lowbit(int i) {
        return i & -i;
    }

}
