package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/28
 * Time: 上午9:47
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Bit Manipulation
 * Hide Similar Problems (E) Reverse Bits (E) Power of Two (M) Counting Bits
 */
public class P191Numberof1Bits {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {//要用不等于0判断，而不是大于0,因为2147483648这个数已经越界
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }

    public int hammingWeight1(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P191Numberof1Bits().hammingWeight(11));
        System.out.println(new P191Numberof1Bits().hammingWeight(Integer.MAX_VALUE));
    }
}
