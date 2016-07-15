package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/6
 * Time: 上午9:33
 * Reverse a singly linked list.
 * click to show more hints.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 * Hide Similar Problems (M) Reverse Linked List II (M) Binary Tree Upside Down (E) Palindrome Linked List
 * Have you met this question in a real interview? Yes
 */
public class P206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head, p2 = head.next;
        while (p1 != null && p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        head.next = null;
        ListNode result = (p2 == null ? p1 : p2);
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new P206ReverseLinkedList();
    }

}
