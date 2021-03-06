package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/3
 * Time: 下午4:02
 */
public class P013RomanToInt {

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map(s.charAt(i)) > map(s.charAt(i - 1))) {
                res += map(s.charAt(i)) - 2 * (map(s.charAt(i - 1)));
            } else {
                res += map(s.charAt(i));
            }
        }

        return res;
    }

    private int map(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P013RomanToInt().romanToInt("IV"));
        System.out.println(new P013RomanToInt().romanToInt("VI"));
    }
}
