package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/15
 * Time: 上午9:20
 * <p/>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * <p/>
 * 在遇到当前元素和前一个元素相等时，如果前一个元素visited[i - 1] == false, 那么我们就跳过当前元素并进入下一次循环，
 * 这就是剪枝的关键所在。另一点需要特别注意的是这种剪枝的方法能使用的前提是提供的nums是有序数组，否则无效。
 */
public class P047PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Boolean> visited = new ArrayList<Boolean>();
        for (int i = 0; i < nums.length; i++) {
            visited.add(false);
        }

        backTrack(nums, new ArrayList<Integer>(), visited, result);
        return result;
    }

    private void backTrack(int[] nums, ArrayList<Integer> item, List<Boolean> visited, List<List<Integer>> result) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited.get(i) || (i != 0 && nums[i] == nums[i - 1]
                    && !visited.get(i - 1))) {
                continue;
            }
            visited.set(i, true);
            item.add(nums[i]);
            backTrack(nums, item, visited, result);
            item.remove(item.size() - 1);
            visited.set(i, false);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new P047PermutationsII().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

}
