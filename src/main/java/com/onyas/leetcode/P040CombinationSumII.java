package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/15
 * Time: 下午5:11
 * <p/>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class P040CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

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
            // ensure only the first same num is chosen, remove duplicate list
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                return;
            }
            item.add(candidates[i]);
            // i + 1 ==> only be used once
            dfs(candidates, target - candidates[i], i+1, item, result);//元素不重复时
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new P040CombinationSumII().combinationSum2(new int[]{1,1}, 1);
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
        System.out.println(result.size());
    }

}
