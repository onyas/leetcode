package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/8/4
 * Time: 上午9:32
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * Note:
 * You can assume that you can always reach the last index.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Greedy
 */
public class P045JumpGameII {

    public int jump(int[] nums) {
        int result = 0;
        //用来记录可以到达的最大地址
        int last = 0;
        //用来记录当前可以到达的最大地址
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = current;
                result++;
            }
            current = Math.max(current, nums[i] + i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P045JumpGameII().jump(new int[]{2, 3, 1, 1, 4}));
    }

}
