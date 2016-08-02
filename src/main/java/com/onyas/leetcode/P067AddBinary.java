package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/21
 * Time: 上午9:01
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * Subscribe to see which companies asked this question
 * Hide Tags Math String
 * Hide Similar Problems (M) Add Two Numbers (M) Multiply Strings (E) Plus One
 */
public class P067AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int lengthA = a.length() - 1;
        int lengthB = b.length() - 1;

        StringBuffer result = new StringBuffer();
        int carry = 0;
        while (lengthA >= 0 || lengthB >= 0) {
            int valueA = 0, valueB = 0;
            if (lengthA >= 0) {
                valueA = a.charAt(lengthA) == '0' ? 0 : 1;
                lengthA--;
            }
            if (lengthB >= 0) {
                valueB = b.charAt(lengthB) == '0' ? 0 : 1;
                lengthB--;
            }
            int sum = valueA + valueB + carry;
            if (sum >= 2) {
                result.append(sum - 2);
                carry = 1;
            } else {
                result.append(sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new P067AddBinary().addBinary("11", "1"));
        System.out.println(new P067AddBinary().addBinary("111", "1"));
        System.out.println(new P067AddBinary().addBinary("110", "1"));
    }
}
