package com.onyas.leetcode;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/15
 * Time: 上午9:24
 * <p/>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Array Depth-first Search
 * Hide Similar Problems (M) Construct Binary Tree from Preorder and Inorder Traversal
 * Have you met this question in a real interview? Yes  No
 * Discuss
 */
public class P106ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode recursion(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> data) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = data.get(root.val);
        root.left = recursion(postorder, postStart, index - inStart + postStart - 1, inorder, inStart, index - 1, data);
        root.right = recursion(postorder, postEnd - (inEnd - index), postEnd - 1, inorder, index + 1, inEnd, data);

        return root;
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
    }
}
