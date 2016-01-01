package com.onyas.leetcode;

/**
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. <br/>
 * Input: (2 -> 4-> 3) + (5 -> 6 -> 4) <br/>
 * Output: 7 -> 0 -> 8
 * 
 * @author Administrator
 *
 */
public class P002AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode result = new ListNode(0);
		ListNode head = result;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			head.next = new ListNode(carry % 10);
			head = head.next;
			carry = carry / 10;
		}
		if (carry == 1) {
			head.next = new ListNode(1);
		}
		return result.next;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode response = new P002AddTwoNumbers().addTwoNumbers(
				new P002AddTwoNumbers.ListNode(0),
				new P002AddTwoNumbers.ListNode(0));
		System.out.println(response.val);
	}

}
