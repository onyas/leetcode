package com.onyas.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * <p/>
 * Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
 * Then we can skip the characters immediately when we found a repeated character.
 * The reason is that if s[j] have a duplicate in the range [i,j) with index, we don't need to increase i i little by little.
 * We can skip all the elements in the range
 * <p/>
 * Hash Table Two Pointers String
 * Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters
 *
 * @author Administrator
 */
public class P003LongestSubstringWithoutRepeatingCharacters {

    /**
     * O(n) runtime and O(n) space
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> datas = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < n; j++) {
            if (datas.containsKey(s.charAt(j))) {
                i = Math.max(i, datas.get(s.charAt(j)));
            }
            result = Math.max(result, j - i + 1);
            datas.put(s.charAt(j), j + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        P003LongestSubstringWithoutRepeatingCharacters p3 = new P003LongestSubstringWithoutRepeatingCharacters();
//        System.out.println("expect 0,real " + p3.lengthOfLongestSubstring(""));
//        System.out.println("expect 1,real " + p3.lengthOfLongestSubstring("b"));
//        System.out
//                .println("expect 2,real " + p3.lengthOfLongestSubstring("ab"));
//        System.out.println("expect 1,real "
//                + p3.lengthOfLongestSubstring("bbbb"));
//        System.out.println("expect 3,real "
//                + p3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("expect 4,real "
                + p3.lengthOfLongestSubstring("bbabcdb"));
//        System.out.println("expect 2,real "
//                + p3.lengthOfLongestSubstring("abba"));
    }

}
