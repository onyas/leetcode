package com.onyas.leetcode;


/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/6
 * Time: 上午8:59
 * <p/>
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (E) Maximum Depth of Binary Tree
 * <p/>
 * 要判断树是否平衡，根据题目的定义，深度是比需的信息，所以我们必须维护深度，另一方面我们又要返回是否为平衡树，那么对于左右子树深度差的判断也是必要的。
 * 这里我们用一个整数来做返回值，而0或者正数用来表示树的深度，而-1则用来比较此树已经不平衡了，如果已经不平衡，则递归一直返回-1即可，也没有继续比较的必要了，
 * 否则就利用返回的深度信息看看左右子树是不是违反平衡条件，如果违反返回-1，否则返回左右子树深度大的加一作为自己的深度即可。
 * 算法的时间是一次树的遍历O(n)，空间是栈高度O(logn)。代码如下：
 */
public class P110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return recursion(root) >= 0;
    }

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursion(root.left);
        int right = recursion(root.right);
        if (left < 0 || right < 0) {
            return -1;
        }
        if (Math.abs(left - right) >= 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
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

        System.out.println(new P110BalancedBinaryTree().isBalanced(root));
    }
}
