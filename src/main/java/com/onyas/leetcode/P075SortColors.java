package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/8
 * Time: 下午3:37
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * click to show follow up.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 * Subscribe to see which companies asked this question
 * Hide Tags Array Two Pointers Sort
 * Hide Similar Problems (M) Sort List (M) Wiggle Sort (M) Wiggle Sort II
 */
public class P075SortColors {

    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int a = -1, b = -1, c = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++a] = 2;
                nums[++b] = 1;
                nums[++c] = 0;
            } else if (nums[i] == 1) {
                nums[++a] = 2;
                nums[++b] = 1;
            } else {
                nums[++a] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 0, 0, 2, 1, 1};
        new P075SortColors().sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
