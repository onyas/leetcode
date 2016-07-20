package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/20
 * Time: 上午9:56
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 * Hide Similar Problems (E) Swap Nodes in Pairs
 * <p/>
 * 我们统计目前节点数量，如果到达k，就把当前k个结点reverse，这里需要reverse linked list的subroutine。这里我们需要先往前走，
 * 到达k的时候才做reverse，所以总体来说每个结点会被访问两次。总时间复杂度是O(2*n)=O(n)，空间复杂度是O(1)
 */
public class P025ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            ListNode next = current.next;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }
            current = next;
        }
        return dummy.next;
    }

    /*
 * 0->1->2->3->4->5->6
 * |           |
 * pre        next
 *
 * after calling pre = reverse(pre, next)
 *
 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next
 */
    private ListNode reverse(ListNode pre, ListNode end) {
        ListNode last = pre.next;
        ListNode current = last.next;
        while (current != end) {
            last.next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = last.next;
        }
        return last;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){

    }
}
