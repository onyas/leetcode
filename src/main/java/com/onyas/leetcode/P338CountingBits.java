package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/8/2
 * Time: 上午8:58
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * Hint:
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 * Credits:
 * Special thanks to @ syedee for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Dynamic Programming Bit Manipulation
 * Hide Similar Problems (E) Number of 1 Bits
 * 巧妙的利用了i&(i - 1)， 这个本来是用来判断一个数是否是2的指数的快捷方法，比如8，二进制位1000, 那么8&(8-1)为0，只要为0就是2的指数,
 * 那么我们现在来看一下0到15的数字和其对应的i&(i - 1)值：
 * i    bin       '1'    i&(i-1)
 * 0    0000    0
 * -----------------------
 * 1    0001    1    0000
 * -----------------------
 * 2    0010    1    0000
 * 3    0011    2    0010
 * -----------------------
 * 4    0100    1    0000
 * 5    0101    2    0100
 * 6    0110    2    0100
 * 7    0111    3    0110
 * -----------------------
 * 8    1000    1    0000
 * 9    1001    2    1000
 * 10   1010    2    1000
 * 11   1011    3    1010
 * 12   1100    2    1000
 * 13   1101    3    1100
 * 14   1110    3    1100
 * 15   1111    4    1110
 * 我们可以发现每个i值都是i&(i-1)对应的值加1，这样我们就可以写出代码如下：
 */
public class P338CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & i - 1] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int result[] = new P338CountingBits().countBits(5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
