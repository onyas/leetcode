package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/29
 * Time: 上午11:09
 * <p/>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Backtracking
 * Hide Similar Problems (M) Combination Sum    Combinations
 */
public class P216CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0) {
            return result;
        }

        helper(k, n, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int k, int n, int start, ArrayList<Integer> items, List<List<Integer>> result) {
        if (k == items.size()) {
            if (isValid(n, items)) {
                result.add(new ArrayList<Integer>(items));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            items.add(i);
            helper(k, n, i + 1, items, result);
            items.remove(items.size() - 1);
        }
    }

    private boolean isValid(int n, ArrayList<Integer> items) {
        for (Integer item : items) {
            n -= item;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new P216CombinationSumIII().combinationSum3(3, 7));
        System.out.println(new P216CombinationSumIII().combinationSum3(3, 9));
    }
}
