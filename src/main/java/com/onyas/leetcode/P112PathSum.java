package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/6
 * Time: 上午9:37
 * <p/>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (M) Path Sum II (H) Binary Tree Maximum Path Sum (M) Sum Root to Leaf Numbers
 */
public class P112PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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

        System.out.println(new P112PathSum().hasPathSum(root,4));
        System.out.println(new P112PathSum().hasPathSum(root,3));
    }
}
