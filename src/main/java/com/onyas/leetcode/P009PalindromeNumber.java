package com.onyas.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/2
 * Time: 下午3:40
 */
public class P009PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int carry = 1;
        while (x / carry >= 10) {
            carry *= 10;
        }

        while (x != 0) {
            int left = x / carry;
            int right = x % 10;

            if (right != left) {
                return false;
            }

            x = (x % carry) / 10;//remove the first and last position
            carry /= 100;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new P009PalindromeNumber().isPalindrome(123));
        System.out.println(new P009PalindromeNumber().isPalindrome(121));
    }

}
