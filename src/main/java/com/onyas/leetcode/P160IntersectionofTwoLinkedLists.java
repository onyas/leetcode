package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/18
 * Time: 上午9:51
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List
 *
 * 思路就是分别计算两个列表的长度，找到差值，然后比较长的那个列表先走diff步，这样，如果有相等的值，直接返回就行
 */
public class P160IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        if (p1 == null || p2 == null) {
            return null;
        }

        int lengthA = 0, lengthB = 0;
        while (p1 != null) {
            lengthA++;
            p1 = p1.next;
        }

        while (p2 != null) {
            lengthB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        int diff = 0;
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            int i = 0;
            while (i < diff) {
                i++;
                p1 = p1.next;
            }
        } else {
            diff = lengthB - lengthA;
            int i = 0;
            while (i < diff) {
                i++;
                p2 = p2.next;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
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
