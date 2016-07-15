package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/15
 * Time: 上午9:43
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Array Two Pointers
 * Hide Similar Problems (H) First Missing Positive (M) Single Number (M) Linked List Cycle II (M) Missing Number
 */
public class P287FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int count = 0;
            for (int i : nums) {
                if (i <= middle) {
                    count++;
                }
            }
            if (count <= middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new P287FindtheDuplicateNumber().findDuplicate(new int[]{1, 1, 2}));
        System.out.println(new P287FindtheDuplicateNumber().findDuplicate(new int[]{1, 2, 2}));
        System.out.println(new P287FindtheDuplicateNumber().findDuplicate(new int[]{1, 2, 3, 4, 5, 5}));
        System.out.println(new P287FindtheDuplicateNumber().findDuplicate(new int[]{1, 2, 3, 3, 4, 5}));
    }
}
