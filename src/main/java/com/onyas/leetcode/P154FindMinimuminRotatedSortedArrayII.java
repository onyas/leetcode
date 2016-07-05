package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/1
 * Time: 上午9:29
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Binary Search
 * Hide Similar Problems (M) Find Minimum in Rotated Sorted Array
 */
public class P154FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == nums[right]) {
                right--;
            } else if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 1, 2, 3, 3, 3};
        System.out.println(new P154FindMinimuminRotatedSortedArrayII().findMin(nums));
        System.out.println(new P154FindMinimuminRotatedSortedArrayII().findMin(new int[]{1, 3}));
    }
}
