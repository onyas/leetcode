package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/8/5
 * Time: 上午9:24
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * Subscribe to see which companies asked this question
 * Hide Tags String
 * Hide Similar Problems (M) Encode and Decode Strings
 */
public class P038CountandSay {

    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String oldString = "1";
        while (n > 1) {
            char[] oldChar = oldString.toCharArray();
            StringBuffer newString = new StringBuffer();
            for (int i = 0; i < oldChar.length; i++) {
                int count = 1;
                while ((i + 1) < oldChar.length && oldChar[i] == oldChar[i + 1]) {
                    count++;
                    i++;
                }
                newString.append(count).append(oldChar[i]);
            }
            oldString = newString.toString();
            n--;
        }

        return oldString;
    }

    public static void main(String[] args){
        System.out.println(new P038CountandSay().countAndSay(1));
        System.out.println(new P038CountandSay().countAndSay(2));
        System.out.println(new P038CountandSay().countAndSay(3));
    }
}
