package com.onyas.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/18
 * Time: 上午10:05
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Subscribe to see which companies asked this question
 * Hide Tags Divide and Conquer Linked List Heap
 * Hide Similar Problems (E) Merge Two Sorted Lists (M) Ugly Number II
 *
 * 思路：用优先级队列，因为有按照值比较的comparator,所以先把每个列表的头节点存到优先级队列中，然后迭代这个队列。
 * 每拉出一个节点时(有序)，加到返回节点后面，并判断这个节点是否有后继节点，如果有的话加入优先级队列中
 */
public class P023MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode node : lists) {
            if(node!=null){
                queue.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
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
