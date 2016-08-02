package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/22
 * Time: 上午9:06
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math
 * Hide Similar Problems (E) Excel Sheet Column Number
 */
public class P168ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        while (n > 0) {
            n--;
            char c = (char) (n % 26 + 'A');
            result.append(c);
            n /= 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(new P168ExcelSheetColumnTitle().convertToTitle(26));
        System.out.println(new P168ExcelSheetColumnTitle().convertToTitle(27));
        System.out.println(new P168ExcelSheetColumnTitle().convertToTitle(28));
    }
}
