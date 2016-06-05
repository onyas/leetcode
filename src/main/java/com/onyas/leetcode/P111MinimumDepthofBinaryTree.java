package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/3
 * Time: 上午9:32
 * <p/>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search Breadth-first Search
 * Hide Similar Problems (E) Binary Tree Level Order Traversal (E) Maximum Depth of Binary Tree
 *
 * 只是这道题因为是判断最小深度，所以必须增加一个叶子的判断（因为如果一个节点如果只有左子树或者右子树，我们不能取它左右子树中小的作为深度，因为那样会是0，
 * 我们只有在叶子节点才能判断深度，而在求最大深度的时候，因为一定会取大的那个，所以不会有这个问题）
 */
public class P111MinimumDepthofBinaryTree {

    //method 1
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    //method 2
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null)
            return minDepth1(root.right)+1;
        if(root.right == null)
            return minDepth1(root.left)+1;
        return Math.min(minDepth1(root.right),minDepth1(root.left))+1;
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

        System.out.println(new P111MinimumDepthofBinaryTree().minDepth(root));
    }
}
