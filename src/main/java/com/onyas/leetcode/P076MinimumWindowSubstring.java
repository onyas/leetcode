package com.onyas.leetcode;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/13
 * Time: 上午8:59
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * Subscribe to see which companies asked this question
 * Hide Tags Hash Table Two Pointers String
 * Hide Similar Problems (H) Substring with Concatenation of All Words (M) Minimum Size Subarray Sum (H) Sliding Window Maximum
 * <p/>
 * 可以利用两个指针扫描（两个指针分别为start，i），以S = “e b a d b a c c b”（忽略空格），T = “abc”为例：
 * 0 1 2 3 4 5 6 7 8
 * <p/>
 * 初始化 start = i = 0
 * i 逐渐往后扫描S直到窗口S[start…i]包含所有T的字符，此时i = 6（字符c的位置）
 * 缩减窗口：此时我们注意到窗口并不是最小的，需要调整 start 来缩减窗口。缩减规则为：如果S[start]不在T中 或者 S[start]在T中但是删除后窗口依然可以包含T中的所有字符，
 * 那么start = start+1， 直到不满足上述两个缩减规则。缩减后i即为窗口的起始位置，此例中从e开始窗口中要依次删掉e、b、a、d，start最后等于4 ，
 * 那么得到一个窗口大小为6-4+1 = 3   start = start+1(此时窗口肯定不会包含所有的T中的字符)，跳转到步骤2继续寻找下一个窗口。本例中还以找到一个窗口start = 5，i = 8，比上个窗口大
 * ，因此最终的最小窗口是S[4…6]
 */
public class P076MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t.length() > s.length()) {
            return "";
        }

        //tdata用于存储字符串t中各字符出现的次数
        HashMap<Character, Integer> tdata = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (tdata.containsKey(t.charAt(i))) {
                tdata.put(t.charAt(i), tdata.get(t.charAt(i)) + 1);
            } else {
                tdata.put(t.charAt(i), 1);
            }
        }

        int minLength = s.length() + 1;
        int left = 0, start = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            if (tdata.containsKey(s.charAt(right))) {
                tdata.put(s.charAt(right), tdata.get(s.charAt(right)) - 1);
                if (tdata.get(s.charAt(right)) >= 0) {
                    count++;
                }

                while (count == t.length()) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        start = left;
                    }

                    if (tdata.containsKey(s.charAt(left))) {
                        tdata.put(s.charAt(left), tdata.get(s.charAt(left)) + 1);

                        if (tdata.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        if (minLength > s.length()) {
            return "";
        }
        return s.substring(start, start + minLength);
    }

    public static void main(String[] args){
        System.out.println(new P076MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
    }

}
