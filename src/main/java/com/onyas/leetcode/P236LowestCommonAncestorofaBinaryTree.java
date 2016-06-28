package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/21
 * Time: 上午9:15
 * <p/>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree
 * Hide Similar Problems (E) Lowest Common Ancestor of a Binary Search Tree
 * <p/>
 * // 在root为根的二叉树中找A,B的LCA:
 * // 如果找到了就返回这个LCA
 * // 如果只碰到A，就返回A
 * // 如果只碰到B，就返回B
 * // 如果都没有，就返回null
 */
public class P236LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        if (right != null && left != null) {
            return root;
        }

        //if right or left is not null,return it.but if all of them is null,then return null;
        return right == null ? (left == null ? null : left) : right;
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
        new P236LowestCommonAncestorofaBinaryTree();
    }
}
