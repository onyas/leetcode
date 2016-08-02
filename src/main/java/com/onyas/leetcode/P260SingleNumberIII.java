package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/28
 * Time: 上午8:58
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Bit Manipulation
 * Hide Similar Problems (M) Single Number (M) Single Number II
 * 首先我们先把原数组全部异或起来，那么我们会得到一个数字，这个数字是两个不相同的数字异或的结果，我们取出其中任意一位为‘1’的位，
 * 为了方便起见，我们用 a &= -a 来取出最右端为‘1’的位，然后和原数组中的数字挨个相与，那么我们要求的两个不同的数字就被分到了两个小组中，
 * 分别将两个小组中的数字都异或起来，就可以得到最终结果了，参见代码如下：
 */
public class P260SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }
        diff &= -diff;

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((diff & nums[i]) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] result = new P260SingleNumberIII().singleNumber(new int[]{1, 1, 2, 3});
        int[] result = new P260SingleNumberIII().singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 5});
//        int[] result = new P260SingleNumberIII().singleNumber(new int[]{2, 2, 3, 3, 4, 5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println("");

        System.out.println(10 & (-10));
        System.out.println(8 & (-8));
    }

}
