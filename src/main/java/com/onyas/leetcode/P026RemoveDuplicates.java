package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/4
 * Time: 下午8:54
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Two Pointers
 * Hide Similar Problems (E) Remove Element
 * 做法是维护两个指针，一个保留当前有效元素的长度，一个从前往后扫，然后跳过那些重复的元素。因为数组是有序的，所以重复元素一定相邻，不需要额外记录。
 * 时间复杂度是O(n)，空间复杂度O(1)。代码如下：
 */
public class P026RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1;//start from 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[result - 1]) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new P026RemoveDuplicates().removeDuplicates(new int[]{1, 2}));
        System.out.println(new P026RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(new P026RemoveDuplicates().removeDuplicates(new int[]{1, 2, 2, 3}));
    }
}
