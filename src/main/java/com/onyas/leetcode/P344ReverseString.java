package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/5
 * Time: 上午9:12
 * <p/>
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * Subscribe to see which companies asked this question
 * Hide Tags Two Pointers String
 * Hide Similar Problems (E) Reverse Vowels of a String
 */
public class P344ReverseString {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];
        while (left <= right) {
            char temp = s.charAt(left);
            result[left++] = s.charAt(right);
            result[right--] = temp;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new P344ReverseString().reverseString("hello"));
        System.out.println(new P344ReverseString().reverseString("world"));
    }

}
