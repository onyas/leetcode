package com.onyas.leetcode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/16
 * Time: 上午9:55
 * <p/>
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * click to show hints.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 *
 * 这是树的题目，要求把一颗二叉树按照先序遍历顺序展成一个链表，不过这个链表还是用树的结果，就是一直往右走（没有左孩子）来模拟链表。
 * 老套路还是用递归来解决，维护先序遍历的前一个结点pre，然后每次把pre的左结点置空，右结点设为当前结点。这里需要注意的一个问题就是我们要先把右子结点保存一下，
 * 以便等会可以进行递归，否则有可能当前结点的右结点会被覆盖，后面就取不到了。算法的复杂度时间上还是一次遍历，O(n)。空间上是栈的大小，O(logn)。代码如下
 */
public class P114FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        recursion(root, pre);
    }

    private void recursion(TreeNode root, ArrayList<TreeNode> pre) {
        if (root == null) {
            return;
        }

        TreeNode right = root.right;
        if (pre.get(0) != null) {
            pre.get(0).left = null;
            pre.get(0).right = root;
        }

        pre.set(0, root);
        recursion(root.left, pre);
        recursion(right, pre);
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
        System.out.println(new P114FlattenBinaryTreetoLinkedList());
    }
}
