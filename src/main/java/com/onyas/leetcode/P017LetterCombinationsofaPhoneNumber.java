package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/27
 * Time: 上午9:00
 * <p/>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * Subscribe to see which companies asked this question
 * Hide Tags Backtracking String
 * Hide Similar Problems (M) Generate Parentheses (M) Combination Sum
 */
public class P017LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, char[]> datas = new HashMap<Character, char[]>();
        datas.put('0', new char[]{});
        datas.put('1', new char[]{});
        datas.put('2', new char[]{'a', 'b', 'c'});
        datas.put('3', new char[]{'d', 'e', 'f'});
        datas.put('4', new char[]{'g', 'h', 'i'});
        datas.put('5', new char[]{'j', 'k', 'l'});
        datas.put('6', new char[]{'m', 'n', 'o'});
        datas.put('7', new char[]{'p', 'q', 'r', 's'});
        datas.put('8', new char[]{'t', 'u', 'v'});
        datas.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuffer sb = new StringBuffer();

        helper(digits, datas, sb, result);

        return result;
    }

    private void helper(String digits, Map<Character, char[]> datas, StringBuffer sb, ArrayList<String> result) {
        if (digits.length() == sb.length()) {
            result.add(sb.toString());
            return;
        }

        for (Character c : datas.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(digits, datas, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(new P017LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }

}
