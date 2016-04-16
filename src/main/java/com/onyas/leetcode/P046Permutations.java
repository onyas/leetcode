package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/13
 * Time: 下午4:04
 * <p/>
 * Given a collection of distinct numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * <p/>
 * 全排列问题
 */
public class P046Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        dfs(nums, new ArrayList<Integer>(), result);

        return result;
    }

    private void dfs(int[] nums, ArrayList<Integer> items, List<List<Integer>> result) {

        if (nums.length == items.size()) {
            result.add(new ArrayList<Integer>(items));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (items.contains(nums[i])) {
                continue;
            }
            items.add(nums[i]);
            dfs(nums, items, result);
            items.remove(items.size() - 1);
        }

    }

    public static void main(String[] args){
        List<List<Integer>> result =  new P046Permutations().permute(new int[]{1,2,3});
        for(List<Integer> item : result){
            for(Integer i :item){
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

}
