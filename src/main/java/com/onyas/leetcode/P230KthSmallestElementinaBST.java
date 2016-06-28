package com.onyas.leetcode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/21
 * Time: 上午9:28
 * <p/>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * Hint:
 * Try to utilize the property of a BST.
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Tree
 * Hide Similar Problems (M) Binary Tree Inorder Traversal
 */
public class P230KthSmallestElementinaBST {


    public int kthSmallest(TreeNode root, int k) {
        int result = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                k--;
                if (k == 0) {
                    result = root.val;
                }
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
        new P230KthSmallestElementinaBST();
    }
}
