package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/25
 * Time: 上午9:16
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math
 * Hide Similar Problems (E) Happy Number (E) Count Primes (M) Ugly Number II
 * <p/>
 * 如果发现可以除尽2，3，5，则一直除下去
 */
public class P263UglyNumber {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num >= 2 && num % 2 == 0) {
            num /= 2;
        }

        while (num >= 3 && num % 3 == 0) {
            num /= 3;
        }

        while (num >= 5 && num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new P263UglyNumber().isUgly(6));
        System.out.println(new P263UglyNumber().isUgly(8));
        System.out.println(new P263UglyNumber().isUgly(14));
    }

}
