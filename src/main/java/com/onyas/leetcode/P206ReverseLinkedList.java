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
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
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
