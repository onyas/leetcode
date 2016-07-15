package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/8
 * Time: 上午9:20
 * <p/>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List Two Pointers
 * Hide Similar Problems (E) Rotate Array
 * （1）第一个辅助指针从头开始后移k个位置。
 * （2）这时第二个辅助指针指向头指针，然后两个指针同时向后移动，直到第一个辅助指针指向尾节点。
 * （3）声明第三个辅助指针指向第二个辅助指针的后继结点作为将要返回的新头指针。把第二个指针的后继设为空指针，同时将第一个指针的后继指向原先的指针。
 * 这儿样就能完成指针的旋转。
 */
public class P061RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 0;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        n++;
        k = k % n;
        p.next = head;
        ListNode q = head;
        for (int i = 0; i < n - k - 1; i++) {
            q = q.next;
        }
        head = q.next;
        q.next = null;
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
