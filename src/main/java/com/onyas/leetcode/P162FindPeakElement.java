package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/2
 * Time: 上午9:09
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * click to show spoilers.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Array
 * <p/>
 * 因为num[-1] = num[n] = -∞是最小的，所以只需要从中间向两边找，往左边找降序的，往右边找升序的，如果刚好没有，那直接返回中间的，因为那就是个峰值 例如[3,5,1]
 * 最坏情况就是一直向左或向右找，直到最后，那就是0或n  时间复杂度Ologn  例如[3,2,1]或[1,2,3]
 */
public class P162FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int left = 1, right = nums.length - 2;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[middle - 1]) {
                right = middle - 1;
            } else if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        if (nums[left] < nums[right]) {
            return right;
        } else {
            return left;
        }
    }


    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 10, 1};
        System.out.println(new P162FindPeakElement().findPeakElement(nums));
        System.out.println(new P162FindPeakElement().findPeakElement(new int[]{1}));
        System.out.println(new P162FindPeakElement().findPeakElement(new int[]{3, 2, 1}));
        System.out.println(new P162FindPeakElement().findPeakElement(new int[]{3, 5, 1}));
    }
}
