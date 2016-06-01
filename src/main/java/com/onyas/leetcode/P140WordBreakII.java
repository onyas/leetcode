package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/29
 * Time: 上午10:46
 * <p/>
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * Subscribe to see which companies asked this question
 * Hide Tags Dynamic Programming Backtracking
 */
public class P140WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            return result;
        }

        helper(s, wordDict, result, 0, "");
        return result;
    }

    private void helper(String s, Set<String> wordDict, List<String> result, int start, String item) {
        if (start >= s.length()) {
            result.add(item);
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                String newItem = item.length() > 0 ? (item + " " + sb.toString()) : sb.toString();
                helper(s, wordDict, result, i + 1, newItem);
            }
        }
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(new P140WordBreakII().wordBreak("catsanddog", wordDict));
    }
}
