package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/14
 * Time: 上午9:26
 *
 * <p/>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p/>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 *
 * 从中我们可以看出只能从重复元素的第一个持续往下添加到列表中，而不能取第二个或之后的重复元素。参考上一题Subsets的模板，
 * 能代表「重复元素的第一个」即为 for 循环中的pos变量，i == pos时，i处所代表的变量即为某一层遍历中得「第一个元素」，
 * 因此去重时只需判断i != pos && s[i] == s[i - 1](不是 i + 1, 可能索引越界，而i 不等于 pos 已经能保证 i >= 1).
 *
 */
public class P090SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> item, List<List<Integer>> results) {

        results.add(new ArrayList<Integer>(item));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            item.add(nums[i]);
            dfs(nums, i + 1, item, results);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new P090SubsetsII().subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }
}
