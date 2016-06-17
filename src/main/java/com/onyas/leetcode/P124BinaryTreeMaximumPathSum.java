package com.onyas.leetcode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/17
 * Time: 上午9:12
 * <p/>
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path does not need to go through the root.
 * For example:
 * Given the below binary tree,
 * 1
 * / \
 * 2   3
 * Return 6.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (E) Path Sum (M) Sum Root to Leaf Numbers
 * <p/>
 * 这道题是求树的路径和的题目，不过和平常不同的是这里的路径不仅可以从根到某一个结点，而且路径可以从左子树某一个结点，
 * 然后到达右子树的结点，就像题目中所说的可以起始和终结于任何结点。在这里树没有被看成有向图，而是被当成无向图来寻找路径。
 * 因为这个路径的灵活性，我们需要对递归返回值进行一些调整，而不是通常的返回要求的结果。在这里，函数的返回值定义为以自己为根的一条从根到子结点的最长路径
 * （这里路径就不是当成无向图了，必须往单方向走）。这个返回值是为了提供给它的父结点计算自身的最长路径用，而结点自身的最长路径（也就是可以从左到右那种）
 * 则只需计算然后更新即可。这样一来，一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），加上右子树的返回值（如果大于0的话），再加上自己的值。
 * 而返回值则是自己的值加上左子树返回值，右子树返回值或者0（注意这里是“或者”，而不是“加上”，因为返回值只取一支的路径和）。在过程中求得当前最长路径时比较一下是不是目前最长的，
 * 如果是则更新。算法的本质还是一次树的遍历，所以复杂度是O(n)。而空间上仍然是栈大小O(logn)。代码如下：
 */
public class P124BinaryTreeMaximumPathSum {


    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(Integer.MIN_VALUE);

        recursion(root, result);
        return result.get(0);
    }

    private int recursion(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return 0;
        }

        int left = recursion(root.left, result);
        int right = recursion(root.right, result);
        int current = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if (current > result.get(0)) {
            result.set(0, current);
        }
        return root.val + Math.max(right, Math.max(0, left));
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
        System.out.println(new P124BinaryTreeMaximumPathSum());
    }
}
