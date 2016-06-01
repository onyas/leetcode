package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/31
 * Time: 上午8:37
 * <p/>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * Subscribe to see which companies asked this question
 * Hide Tags Backtracking
 * Hide Similar Problems (H) Palindrome Partitioning II
 * <p/>
 * <p/>
 * 这道题是求一个字符串中回文子串的切割，并且输出切割结果，其实是Word Break II和Longest Palindromic Substring结合，
 * 该做的我们都做过了。首先我们根据Longest Palindromic Substring中的方法建立一个字典，得到字符串中的任意子串是不是回文串的字典，
 * 不熟悉的朋友可以先看看哈。接下来就跟Word Break II一样，根据字典的结果进行切割，然后按照循环处理递归子问题的方法，如果当前的子串满足回文条件，
 * 就递归处理字符串剩下的子串。如果到达终点就返回当前结果。算法的复杂度跟Word Break II一样，取决于结果的数量，最坏情况是指数量级的。代码如下：
 */
public class P131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(s, getDicts(s), 0, new ArrayList<String>(), result);
        return result;
    }

    private void helper(String s, boolean[][] dicts, int start, ArrayList<String> items, ArrayList<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<String>(items));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dicts[start][i]) {
                items.add(s.substring(start, i + 1));
                helper(s, dicts, i + 1, items, result);
                items.remove(items.size() - 1);
            }
        }
    }

    private boolean[][] getDicts(String s) {
        boolean dicts[][] = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dicts[i + 1][j - 1])) {
                    dicts[i][j] = true;
                }
            }
        }
        return dicts;
    }

    public static void main(String[] args){
        System.out.println(new P131PalindromePartitioning().partition("aab"));
    }

}
