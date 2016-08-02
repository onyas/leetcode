package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/29
 * Time: 上午9:24
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Bit Manipulation
 * Hide Similar Problems (E) Number of 1 Bits
 * 最简单的做法，原数不断右移取出最低位，赋给新数的最低位后新数再不断左移
 */
public class P190ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | n & 1;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P190ReverseBits().reverseBits(43261596));
        System.out.println(new P190ReverseBits().reverseBits(2));
    }

}
