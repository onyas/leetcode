package com.onyas.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/5
 * Time: 上午10:49
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (E) Balanced Binary Tree (E) Minimum Depth of Binary Tree
 */
public class P104MaximumDepthofBinaryTree {

    //Method recursion
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //method iterative
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int curLevNum = 1;
        int nexLevNum = 0;
        int resultLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            curLevNum--;
            if (treeNode.left != null) {
                nexLevNum++;
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nexLevNum++;
                queue.add(treeNode.right);
            }
            if (curLevNum == 0) {
                curLevNum = nexLevNum;
                nexLevNum = 0;
                resultLevel++;
            }
        }

        return resultLevel;
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

        System.out.println(new P104MaximumDepthofBinaryTree().maxDepth1(root));
        System.out.println(new P104MaximumDepthofBinaryTree().maxDepth(root));

    }
}
