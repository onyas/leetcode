package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/24
 * Time: 上午9:36
 * <p/>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class P094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
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
        System.out.println(new P094BinaryTreeInorderTraversal().inorderTraversal(root));
        System.out.println(new P094BinaryTreeInorderTraversal().inorderTraversal2(root));
    }
}
