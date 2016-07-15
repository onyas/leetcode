package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/14
 * Time: 上午9:03
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * Subscribe to see which companies asked this question
 * Hide Tags Hash Table Two Pointers String
 * Hide Similar Problems (H) Minimum Window Substring
 * 因为words中的单词可能有重复，所以要有一个dict来记录一下每个字符串的数目。然后在遍历原字符串的时候，只需要遍历单词的长度次即可，如"barfoothefoobarman"，
 * 因为目标单词的长度为3，所以只需遍历：+
 * <p/>
 * 'bar' | 'foo' | 'the' | 'foo' | 'bar' | 'man'
 * 'arf' | 'oot' | 'hef' | 'oob' | 'arm'
 * 'rfo' | 'oth' | 'efo' | 'oba' | 'rma'
 * 在遍历时，需要两个指针，一个用来标记子字符串的开始，另一个用来标记子字符串的结束。再用一个dict来记录当前字符串中单词的数量，如果下一个单词不在words中，
 * 那么清空该dict，把前指针直接跳到后指针处；如果在words中，那么相应的键值要加一，此时如果那个单词的数量超过了目标中的数目，那么前指针要不断后移直到吐出一个那个单词。
 * 通过前后指针之差是否等于所有目标单词长度之和来判断是否有目标子字符串。
 */
public class P030SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        int sLength = s.length();
        int wordSize = words.length, wordLength = words[0].length(), wordsLength = wordSize * wordLength;
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> wordDic = new HashMap<String, Integer>();

        for (String word : words) {
            if (wordDic.containsKey(word)) {
                wordDic.put(word, wordDic.get(word) + 1);
            } else {
                wordDic.put(word, 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            HashMap<String, Integer> currentDic = new HashMap<String, Integer>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (wordDic.containsKey(word)) {
                    if (currentDic.containsKey(word)) {
                        currentDic.put(word, currentDic.get(word) + 1);
                    } else {
                        currentDic.put(word, 1);
                    }
                    while (currentDic.get(word) > wordDic.get(word)) {//如果某个单词重复的次数过多，左指针一直向前走直到吐出一个为至
                        String leftStart = s.substring(left, left + wordLength);
                        if (currentDic.containsKey(leftStart)) {
                            currentDic.put(leftStart, currentDic.get(leftStart) - 1);
                        }
                        left += wordLength;
                    }
                    if (right - left == wordsLength) {//找到一组结果
                        result.add(left);
                    }
                } else {
                    left = right;
                    currentDic.clear();
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new P030SubstringwithConcatenationofAllWords().findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
        System.out.println(new P030SubstringwithConcatenationofAllWords().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(new P030SubstringwithConcatenationofAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best","good"}));
    }

}
