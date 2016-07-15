package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/7
 * Time: 上午9:39
 * <p/>
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 * Hide Similar Problems (E) Remove Element (E) Delete Node in a Linked List
 */
public class P203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return t.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new P203RemoveLinkedListElements();
    }
}
