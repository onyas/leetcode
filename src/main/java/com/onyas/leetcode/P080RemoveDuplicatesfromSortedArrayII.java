package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/15
 * Time: 上午9:27
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Two Pointers
 * 因为可以允许两个重复，所以只需要判断当前元素和它前面的第二个元素是否一样就可以，如果不一样，当前可以添加进去
 */
public class P080RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int result = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[result - 2]) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P080RemoveDuplicatesfromSortedArrayII().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

}
