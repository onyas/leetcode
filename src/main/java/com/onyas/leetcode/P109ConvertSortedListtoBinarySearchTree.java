package com.onyas.leetcode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/16
 * Time: 上午8:55
 * <p/>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * Subscribe to see which companies asked this question
 * Hide Tags Depth-first Search Linked List
 * Hide Similar Problems (M) Convert Sorted Array to Binary Search Tree
 */
public class P109ConvertSortedListtoBinarySearchTree {


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        ArrayList<ListNode> data = new ArrayList<ListNode>();
        data.add(head);

        return recursion(data, 0, length - 1);
    }

    private TreeNode recursion(ArrayList<ListNode> data, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode left = recursion(data, start, middle - 1);
        TreeNode root = new TreeNode(data.get(0).val);
        root.left = left;
        data.set(0, data.get(0).next);
        root.right = recursion(data, middle + 1, end);

        return root;
    }

    private int getLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
        System.out.println(new P109ConvertSortedListtoBinarySearchTree());
    }
}
