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
        StringBuffer s1 = new StringBuffer(num1).reverse();
        StringBuffer s2 = new StringBuffer(num2).reverse();

        int[] multiply = new int[num1.length() + num2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                multiply[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < multiply.length; i++) {
            int mod = multiply[i] % 10;
            int carry = multiply[i] / 10;
            if (i + 1 < multiply.length) {
                multiply[i + 1] += carry;
            }
            result.insert(0, mod);
        }

        while (result.charAt(0) == '0' && result.length() > 1) {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new P043MultiplyStrings().multiply("3","4"));
        System.out.println(new P043MultiplyStrings().multiply("123","20"));
        System.out.println(new P043MultiplyStrings().multiply("0","0"));
    }

}
