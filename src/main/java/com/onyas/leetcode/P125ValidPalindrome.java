package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/6
 * Time: 上午8:49
 * <p/>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * Subscribe to see which companies asked this question
 * Hide Tags Two Pointers String
 * Hide Similar Problems (E) Palindrome Linked List
 */
public class P125ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P125ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

}
