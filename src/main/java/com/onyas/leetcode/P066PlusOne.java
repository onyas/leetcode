package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/21
 * Time: 上午8:56
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Math
 * Hide Similar Problems (M) Multiply Strings (E) Add Binary (M) Plus One Linked List
 * 给一个由包含一串数字的列表组成的非负整数加上一。
 * 注意点：
 * 列表前面的数字表示高位
 * 注意最高位也可能进位
 * 例子：
 * 输入: [1, 2, 3, 4, 9]
 * 输出: [1, 2, 3, 5, 0]
 * <p/>
 * 思路是维护一个进位，对每一位进行加一，然后判断进位，如果有继续到下一位，否则就可以返回了，因为前面不需要计算了。有一个小细节就是如果到了最高位进位仍然存在，
 * 那么我们必须重新new一个数组，然后把第一个为赋成1（因为只是加一操作，其余位一定是0，否则不会进最高位）。因为只需要一次扫描，所以算法复杂度是O(n)，n是数组的长度。
 * 而空间上，一般情况是O(1)
 */
public class P066PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = sum;
            if (carry == 0) {
                return digits;
            }
        }
        int result[] = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {

    }
}
