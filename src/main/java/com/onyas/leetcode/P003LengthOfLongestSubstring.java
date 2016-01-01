package com.onyas.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author Administrator
 *
 */
public class P003LengthOfLongestSubstring {

	/***
	 * O(n) runtime and O(n) space
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> items = new HashMap<Character, Integer>(
				s.length());
		int lastRepeatPos = -1;// tricky
		int maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			// if the item already exist in the map
			if (items.get(s.charAt(i)) != null
					&& lastRepeatPos < items.get(s.charAt(i))) {
				lastRepeatPos = items.get(s.charAt(i));
			}
			if (i - lastRepeatPos > maxlength) {
				maxlength = i - lastRepeatPos;
			}
			items.put(s.charAt(i), i);
		}
		return maxlength;
	}

	
	
	
	public static void main(String[] args) {
		P003LengthOfLongestSubstring p3 = new P003LengthOfLongestSubstring();
		System.out.println("expect 0,real " + p3.lengthOfLongestSubstring(""));
		System.out.println("expect 1,real " + p3.lengthOfLongestSubstring("b"));
		System.out
				.println("expect 2,real " + p3.lengthOfLongestSubstring("ab"));
		System.out.println("expect 1,real "
				+ p3.lengthOfLongestSubstring("bbbb"));
		System.out.println("expect 3,real "
				+ p3.lengthOfLongestSubstring("abcabcbb"));
		System.out.println("expect 4,real "
				+ p3.lengthOfLongestSubstring("bbabcdb"));
		System.out.println("expect 2,real "
				+ p3.lengthOfLongestSubstring("abba"));
	}

}
