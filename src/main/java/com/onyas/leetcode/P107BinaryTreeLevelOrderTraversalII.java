package com.onyas.leetcode;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/3
 * Time: 上午8:54
 * <p/>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Breadth-first Search
 * Hide Similar Problems (E) Binary Tree Level Order Traversal
 */
public class P107BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevelResult = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {

                TreeNode treeNode = queue.poll();
                currentLevelResult.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            result.add(currentLevelResult);
        }
        Collections.reverse(result);
        return result;
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
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(4);
        left.left = left1;

        TreeNode right1 = new TreeNode(5);
        right.right = right1;

        System.out.println(new P107BinaryTreeLevelOrderTraversalII().levelOrderBottom(root));
    }
}
