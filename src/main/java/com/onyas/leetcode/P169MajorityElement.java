package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/29
 * Time: 上午8:58
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Divide and Conquer Bit Manipulation
 * Hide Similar Problems (M) Majority Element II
 * O(n)的时间复杂度可解决；
 * 可以先排序，然后取中间元素，这样时间复杂度为O(nlogn);
 * “投票算法”，设定两个变量candidate和count。candidate保存当前可能的候选众数，count保存该候选众数的出现次数。
 * 遍历数组num。
 * 如果当前的数字e与候选众数candidate相同，则将计数count + 1
 * 否则，如果当前的候选众数candidate为空，或者count为0，则将候选众数candidate的值置为e，并将计数count置为1。
 * 否则，将计数count - 1
 * 最终留下的候选众数candidate即为最终答案。
 */
public class P169MajorityElement {

    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P169MajorityElement().majorityElement(new int[]{1, 1, 1, 2}));
        System.out.println(new P169MajorityElement().majorityElement(new int[]{1, 1, 1, 2, 2, 2, 2}));
        System.out.println(new P169MajorityElement().majorityElement(new int[]{1, 1, 2, 3, 3, 3, 3,}));
    }

}
