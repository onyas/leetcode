package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/25
 * Time: 上午9:31
 */
public class P144BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        TreeNode left = new TreeNode(3);
        right.left = left;
        System.out.println(new P144BinaryTreePreorderTraversal().preorderTraversal(root));
        System.out.println(new P144BinaryTreePreorderTraversal().preorderTraversal1(root));
    }
}
