package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/28
 * Time: 下午9:05
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * Subscribe to see which companies asked this question
 * Hide Tags Array Binary Search
 * Hide Similar Problems (E) First Bad Version
 */
public class P035SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new P035SearchInsertPosition().searchInsert(nums, 5));
        System.out.println(new P035SearchInsertPosition().searchInsert(nums, 2));
        System.out.println(new P035SearchInsertPosition().searchInsert(nums, 7));
        System.out.println(new P035SearchInsertPosition().searchInsert(nums, 0));
    }
}
