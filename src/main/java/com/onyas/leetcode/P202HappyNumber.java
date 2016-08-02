package com.onyas.leetcode;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/25
 * Time: 上午9:08
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of
 * its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Credits:
 * Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Hash Table Math
 * Hide Similar Problems (E) Add Digits (E) Ugly Number
 */
public class P202HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        while (n != 1) {
            if (hashSet.contains(n)) {
                return false;
            }
            hashSet.add(n);
            n = getNetHappyNum(n);
        }
        return true;
    }

    private int getNetHappyNum(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new P202HappyNumber().isHappy(19));
        System.out.println(new P202HappyNumber().isHappy(20));
    }

}
