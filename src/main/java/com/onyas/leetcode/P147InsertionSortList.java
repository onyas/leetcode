package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/19
 * Time: 上午9:46
 * Sort a linked list using insertion sort.
 * Subscribe to see which companies asked this question
 * Hide Tags Linked List Sort
 * Hide Similar Problems (M) Sort List
 * <p/>
 * 插入排序是一种O(n^2)复杂度的算法，基本想法相信大家都比较了解，就是每次循环找到一个元素在当前排好的结果中相对应的位置，然后插进去，
 * 经过n次迭代之后就得到排好序的结果了。了解了思路之后就是链表的基本操作了，搜索并进行相应的插入。时间复杂度是排序算法的O(n^2)，空间复杂度是O(1)。
 */
public class P147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dumpy = new ListNode(0);
        while (head != null) {
            ListNode node = dumpy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dumpy.next;
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
