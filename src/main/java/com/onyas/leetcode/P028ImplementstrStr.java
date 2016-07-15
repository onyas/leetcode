package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/14
 * Time: 下午4:11
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Subscribe to see which companies asked this question
 * Hide Tags Two Pointers String
 * Hide Similar Problems (H) Shortest Palindrome
 * 字符串匹配之Sunday算法
 */
public class P028ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }

        char[] mainArr = haystack.toCharArray();
        char[] targetArr = needle.toCharArray();
        int i = 0;
        while (i < mainArr.length) {
            int j = 0;
            while ((j < targetArr.length) && (i + j < mainArr.length) && (targetArr[j] == mainArr[i + j])) {
                j++;
            }
            if (j == targetArr.length) {
                return i;
            } else {
                if (i + targetArr.length < mainArr.length) {
                    for (j = targetArr.length - 1; j >= 0; j--) {
                        if (targetArr[j] == mainArr[i + targetArr.length]) {
                            break;
                        }
                    }
                }
                i += targetArr.length - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new P028ImplementstrStr().strStr("abcde", "bc"));
        System.out.println(new P028ImplementstrStr().strStr("a", "a"));
    }
}
