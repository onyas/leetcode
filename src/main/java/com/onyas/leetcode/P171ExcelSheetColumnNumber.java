package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/22
 * Time: 上午9:13
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math
 * Hide Similar Problems (E) Excel Sheet Column Title
 * 相当于将一个二十六进制的数字转换为十进制，不过这里的二十六进制比较特殊，不是由1,2,3...A,B,...Q这些数字表示，而是A,B,C...Z来表示。
 * 但原理是一样的，同一个字母往左移一位，它表示的数字就变为原来的26倍。将每个字母根据它所在的位置计算出它表示的值即可。
 */
public class P171ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0, carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            result = result + (int) Math.pow(26, carry) * (current - 'A' + 1);
            carry++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new P171ExcelSheetColumnNumber().titleToNumber("Z"));
        System.out.println(new P171ExcelSheetColumnNumber().titleToNumber("AA"));
        System.out.println(new P171ExcelSheetColumnNumber().titleToNumber("AB"));
        System.out.println(new P171ExcelSheetColumnNumber().titleToNumber("BA"));
    }
}
