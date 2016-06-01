package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/13
 * Time: 上午9:16
 * <p/>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class P077Combinations {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        helper(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int n, int k, int start, ArrayList<Integer> item, List<List<Integer>> result) {

        if (k == item.size()) {
            result.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            helper(n, k, i + 1, item, result);
            item.remove(item.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new P077Combinations().combine(4, 2);
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

}
