package com.onyas.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/29
 * Time: 上午10:05
 * <p/>
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * Subscribe to see which companies asked this question
 * <p/>
 * 这道题仍然是动态规划的题目，我们总结一下动态规划题目的基本思路。
 * 首先我们要决定要存储什么历史信息以及用什么数据结构来存储信息。然后是最重要的递推式，就是如何从存储的历史信息中得到当前步的结果。
 * 最后我们需要考虑的就是起始条件的值。
 * <p/>
 * 接下来我们套用上面的思路来解这道题。首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示，
 * 我们需要一个长度为n的布尔数组来存储信息。然后假设我们现在拥有res[0,...,i-1]的结果，我们来获得res[i]的表达式。思路是对于每个以i为结尾的子串，
 * 看看他是不是在字典里面以及他之前的元素对应的res[j]是不是true，如果都成立，那么res[i]为true，写成式子是
 *
 * result[j] && s.subString(j,i+1)属于dict
 */
public class P139WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);

            for (int j = 0; j <= i; j++) {
                if (result[j] && wordDict.contains(temp)) {
                    result[i + 1] = true;
                    break;
                }
                temp = temp.substring(1);
            }
        }
        return result[s.length()];
    }

    public static void main(String[] args){
        HashSet dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(new P139WordBreak().wordBreak("leetcode",dict));
        System.out.println(new P139WordBreak().wordBreak("leetcodecode",dict));
        System.out.println(new P139WordBreak().wordBreak("leetcodecodeleet",dict));
    }
}
