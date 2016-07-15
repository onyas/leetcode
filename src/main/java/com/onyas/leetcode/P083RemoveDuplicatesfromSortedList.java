package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/7
 * Time: 上午9:24
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 */
public class P083RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;//主要是这步，如果当前值与下一个相等，则当前的下一个跳过下一个值
            } else {
                p = p.next;//如果不相等，就依次向下找
            }
        }
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
        new P083RemoveDuplicatesfromSortedList();
    }

}
