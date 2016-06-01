package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/13
 * Time: 上午10:23
 * <p/>
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p/>
 * 求子集
 */
public class P078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void helper(int[] nums, int start, ArrayList<Integer> items, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(items));

        for (int i = start; i < nums.length; i++) {
            items.add(nums[i]);
            helper(nums, i + 1, items, result);
            items.remove(items.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new P090SubsetsII().subsetsWithDup(new int[]{1, 2, 3});
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }
}
