package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/3
 * Time: 上午8:40
 * <p/>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Breadth-first Search Stack
 * Hide Similar Problems (E) Binary Tree Level Order Traversal
 */
public class P103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> temp;
        boolean normalOrder = true;

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {

            List<Integer> currentLevelResult = new ArrayList<Integer>();

            while (!currentLevel.isEmpty()) {

                TreeNode treeNode = currentLevel.pop();
                currentLevelResult.add(treeNode.val);

                if (normalOrder) {
                    if (treeNode.left != null) {
                        nextLevel.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        nextLevel.add(treeNode.right);
                    }
                } else {
                    if (treeNode.right != null) {
                        nextLevel.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        nextLevel.add(treeNode.left);
                    }
                }
            }

            result.add(currentLevelResult);
            temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            normalOrder = !normalOrder;
        }

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

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(4);
        left.left = left1;

        TreeNode right1 = new TreeNode(5);
        right.right = right1;

        System.out.println(new P103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }
}
