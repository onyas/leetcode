package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/28
 * Time: 下午12:55
 * <p/>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * Subscribe to see which companies asked this question
 * Hide Tags Backtracking String
 */
public class P093RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        helper(result, list, s, 0);

        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int start) {

        if (list.size() == 4) {
            if (start != s.length()) {
                return;
            }

            StringBuffer sb = new StringBuffer();
            for (String str : list) {
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length() && i <= start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if (valid(temp)) {
                list.add(temp);
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    private boolean valid(String temp) {
        if (temp.charAt(0) == '0') {
            return temp.equals("0");// to eliminate cases like "00", "10"
        }
        int digit = Integer.valueOf(temp);
        return digit <= 255 && digit >= 0;
    }

    public static void main(String[] args) {
        System.out.println(new P093RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }

}
