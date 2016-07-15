package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/6
 * Time: 上午9:39
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 * Hide Similar Problems (E) Reverse Linked List
 */
public class P092ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode mPre = null;
        ListNode nNext = new ListNode(0);
        ListNode mNode = new ListNode(0);
        int i = 0;
        ListNode p = head;
        while (p != null) {
            i++;
            if (i == m - 1) {
                mPre = p;
            }
            if (i == m) {
                mNode.next = p;
            }
            if (i == n ) {
                nNext.next = p.next;
                p.next = null;
            }
            p = p.next;
        }

        if (mNode.next == null) {
            return head;
        }

        // reverse list [m, n]
        ListNode p1 = mNode.next;
        ListNode p2 = p1.next;
        p1.next = nNext.next;

        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        //connect to previous part
        if (mPre != null)
            mPre.next = p1;
        else
            return p1;

        return head;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new P092ReverseLinkedListII();
    }
}
