package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/20
 * Time: 上午9:17
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 * （1）将链表切成两半，也就是找到中点，然后截成两条链表；
 * （2）将后面一条链表进行reverse操作，就是反转过来；
 * （3）将两条链表按顺序依次merge起来。
 */
public class P143ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null;

        head2 = reverse(head2);

        while (head != null && head2 != null) {
            ListNode head2Next = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = head2.next;
            head2 = head2Next;
        }
    }

    private ListNode reverse(ListNode head) {
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

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }
}
