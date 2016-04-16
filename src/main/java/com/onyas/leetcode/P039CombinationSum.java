package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/15
 * Time: 下午4:35
 * <p/>
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * 和 Permutations 十分类似，区别在于剪枝函数不同。这里允许一个元素被多次使用，故递归时传入的索引值不自增，而是由 for 循环改变。
 */
public class P039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (candidates == null) return result;

        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> item, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            item.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, item, result);
//            dfs(candidates, target - candidates[i], i+1, item, result);//元素不重复时
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new P039CombinationSum().combinationSum(new int[]{1,2,3,4,5,6,7,8,9}, 24);
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
        System.out.println(result.size());
    }
}
