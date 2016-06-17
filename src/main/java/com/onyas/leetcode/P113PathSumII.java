package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/6
 * Time: 上午9:41
 * <p/>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (E) Path Sum (E) Binary Tree Paths
 */
public class P113PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recursion(root, sum, result, new ArrayList<Integer>());
        return result;
    }

    private void recursion(TreeNode root, int sum, List<List<Integer>> result, ArrayList<Integer> item) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            item.add(root.val);
            result.add(new ArrayList<Integer>(item));
            item.remove(item.size()-1);
        }
        item.add(root.val);
        recursion(root.left, sum - root.val, result, item);
        recursion(root.right, sum - root.val, result, item);
        item.remove(item.size()-1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        System.out.println(new P113PathSumII().pathSum(root,4));
        System.out.println(new P113PathSumII().pathSum(root,3));
    }
}
