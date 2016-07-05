package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/1
 * Time: 上午9:06
 * <p/>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Binary Search
 * Hide Similar Problems (H) Search in Rotated Sorted Array (H) Find Minimum in Rotated Sorted Array II
 * <p/>
 * 通过左边界和中间的大小关系来得到左边或者右边有序的信息，如果左半边有序，那么左半边最小就是左边第一个元素，可以和当前最小相比取小的，
 * 然后走向右半边。否则，那么就是右半半边第一个元素，然后走向左半边。这样子每次可以截掉一半元素，所以最后复杂度等价于一个二分查找，是O(logn)
 */
public class P153FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
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
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new P153FindMinimuminRotatedSortedArray().findMin(nums));
    }

}
