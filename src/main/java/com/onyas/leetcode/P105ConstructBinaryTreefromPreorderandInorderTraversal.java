package com.onyas.leetcode;


import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/15
 * Time: 上午9:10
 * <p/>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Array Depth-first Search
 * Hide Similar Problems (M) Construct Binary Tree from Inorder and Postorder Traversal
 * Have you met this question in a real interview? Yes  No
 * Discuss
 */
public class P105ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode recursion(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> data) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = data.get(root.val);
        root.left = recursion(preorder, preStart + 1, index - inStart + preStart, inorder, inStart, index - 1, data);
        root.right = recursion(preorder, index - inStart + preStart + 1, preEnd, inorder, index + 1, inEnd, data);

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
        int[] preOrder = {1, 2, 4, 5, 3, 6, 8, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 8, 3, 7};

        new P105ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preOrder, inOrder);
    }

}
