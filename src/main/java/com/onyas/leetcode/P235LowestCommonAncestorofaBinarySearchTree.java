package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/21
 * Time: 上午9:01
 * <p/>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree
 * Hide Similar Problems (M) Lowest Common Ancestor of a Binary Tree
 */
public class P235LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;
        if (m.val > p.val && m.val < q.val) {
            return m;
        }

        if (m.val < p.val && m.val < q.val) {
            return lowestCommonAncestor(m.right, p, q);
        }

        if (m.val > p.val && m.val > q.val) {
            return lowestCommonAncestor(m.left, p, q);
        }
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
        new P235LowestCommonAncestorofaBinarySearchTree();
    }
}
