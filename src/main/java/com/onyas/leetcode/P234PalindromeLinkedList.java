package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/6
 * Time: 上午8:54
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List Two Pointers
 * Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse Linked List
 * 思路：用快慢指针找到中间节点，然后后半部分进行反转，然后依次比较两个list的值是否一样
 */
public class P234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        // find middle
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        //reverse
        ListNode p1 = secondHead, p2 = p1.next;
        while (p1 != null && p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        secondHead.next = null;

        //compare
        ListNode p = (p2 == null ? p1 : p2);
        ListNode q = head;
        while (p != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        new P234PalindromeLinkedList();
    }
}

