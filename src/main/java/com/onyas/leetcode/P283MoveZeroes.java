package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/8
 * Time: 上午9:11
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Two Pointers
 * Hide Similar Problems (E) Remove Element
 */
public class P283MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                fast = i + 1;
                while (fast < nums.length) {
                    if (nums[fast] != 0) {
                        nums[i] = nums[fast];
                        nums[fast] = 0;
                        break;
                    }
                    fast++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new P283MoveZeroes().moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
