package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/21
 * Time: 上午9:20
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 * Subscribe to see which companies asked this question
 * Hide Tags Math String
 * Hide Similar Problems (M) Add Two Numbers (E) Plus One (E) Add Binary
 * 将两个用字符串表示的数进行乘法操作并返回字符串结果。
 * 注意点：
 * 给的数是非负整数
 * 数字可以无穷大
 * 例子：
 * 输入: num1 = "123", num2 = "20" 输出: "2460"
 */
public class P043MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return null;
        }
        if (num2 == null || num2.length() == 0) {
            return null;
        }
        int carry = 1;
        StringBuffer result = new StringBuffer();
        int lengthA = num1.length() - 1;
        int lengthB = num2.length() - 1;
        while (lengthA >= 0 || lengthB >= 0) {
            int valueA = 1, valueB = 1;
            if (lengthA >= 0) {
                valueA = num1.charAt(lengthA) - '0';
                lengthA--;
            }
            if (lengthB >= 0) {
                valueB = num2.charAt(lengthB) - '0';
                lengthB--;
            }
            int current = (valueA * valueB) % 10;


        }
        return null;
    }

}
