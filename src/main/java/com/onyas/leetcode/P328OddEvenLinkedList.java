package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/20
 * Time: 上午10:21
 * <p/>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * Credits:
 * Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * <p/>
 * 用两个指针交替指向下一个就可以
 */
public class P328OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;
        while (p1 != null && p2 != null) {
            ListNode temp = p2.next;
            if (temp == null) {
                break;
            }
            p1.next = temp;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = connectNode;
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

    }
}
