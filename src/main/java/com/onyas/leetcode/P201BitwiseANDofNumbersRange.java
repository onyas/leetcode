package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/29
 * Time: 上午9:36
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * Credits:
 * Special thanks to @amrsaqr for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Bit Manipulation
 * 思路：In one word, this problem is asking us to find the common prefix of m and n 's binary code.
 */
public class P201BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= n - 1;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new P201BitwiseANDofNumbersRange().rangeBitwiseAnd(5, 7));
    }
}
