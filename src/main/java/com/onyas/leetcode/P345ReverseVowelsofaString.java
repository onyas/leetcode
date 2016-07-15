package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/5
 * Time: 上午9:20
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Subscribe to see which companies asked this question
 * Hide Tags Two Pointers String
 * Hide Similar Problems (E) Reverse String
 * <p/>
 * 元音字母有五个a,e,i,o,u，需要注意的是大写的也算，所以总共有十个字母。我们写一个isVowel的函数来判断当前字符是否为元音字母，
 * 如果两边都是元音字母，那么我们交换，如果左边的不是，向右移动一位，如果右边的不是，则向左移动一位
 */
public class P345ReverseVowelsofaString {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int left = 0, right = s.length() - 1;
        char[] result = s.toCharArray();
        while (left <= right) {
            if (isVowel(s.charAt(left)) && isVowel(s.charAt(right))) {
                char temp = s.charAt(left);
                result[left++] = s.charAt(right);
                result[right--] = temp;
            } else if (isVowel(s.charAt(left))) {
                right--;
            } else {
                left++;
            }
        }
        return new String(result);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new P345ReverseVowelsofaString().reverseVowels("hello"));
        System.out.println(new P345ReverseVowelsofaString().reverseVowels("leetcode"));
    }
}
