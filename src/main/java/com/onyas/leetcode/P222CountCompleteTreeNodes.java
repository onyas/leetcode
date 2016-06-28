package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/20
 * Time: 上午9:36
 * <p/>
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Binary Search
 * Hide Similar Problems (E) Closest Binary Search Tree Value
 * <p/>
 * 1) get the height of left-most part
 * 2) get the height of right-most part
 * 3) when they are equal, the # of nodes = 2^h -1
 * 4) when they are not equal, recursively get # of nodes from left&right sub-trees
 */
public class P222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root.left) ;
        int rightHeight = getRightHeight(root.right) ;
        if (leftHeight == rightHeight) {
            return (2 << (leftHeight)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftHeight(TreeNode left) {
        if (left == null) {
            return 0;
        }
        int height = 0;
        while (left != null) {
            height++;
            left = left.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode right) {
        if (right == null) {
            return 0;
        }
        int height = 0;
        while (right != null) {
            height++;
            right = right.right;
        }
        return height;
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
        left.left = new TreeNode(4);
        System.out.println(new P222CountCompleteTreeNodes().countNodes(root));
    }

}
