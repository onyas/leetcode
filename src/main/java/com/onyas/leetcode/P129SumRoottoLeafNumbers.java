package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/8
 * Time: 上午9:09
 * <p/>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (E) Path Sum (H) Binary Tree Maximum Path Sum
 */
public class P129SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return recursion(root, 0);
    }

    private int recursion(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return recursion(root.left, sum * 10 + root.val) + recursion(root.right, sum * 10 + root.val);
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

        System.out.println(new P129SumRoottoLeafNumbers().sumNumbers(root));
    }
}
