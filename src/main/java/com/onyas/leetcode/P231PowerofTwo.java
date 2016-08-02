package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/26
 * Time: 上午9:17
 * Given an integer, write a function to determine if it is a power of two.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math Bit Manipulation
 * Hide Similar Problems (E) Number of 1 Bits (E) Power of Three (E) Power of Four
 */
public class P231PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n & n - 1) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new P231PowerofTwo().isPowerOfTwo(16));
        System.out.println(new P231PowerofTwo().isPowerOfTwo(15));
    }

}
