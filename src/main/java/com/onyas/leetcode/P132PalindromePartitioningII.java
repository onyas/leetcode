package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/31
 * Time: 上午9:33
 * <p/>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Subscribe to see which companies asked this question
 * Hide Tags Dynamic Programming
 * Hide Similar Problems (M) Palindrome Partitioning
 *
 * 接下来我们套用上面的思路来解这道题。首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止需要切割的次数
 * 我们需要一个长度为n的布尔数组来存储信息。另外我们要得到字符串回文字典boolean数组。
 * 然后假设我们现在拥有res[0,...,i-1]的结果，我们来获得res[i]的表达式，只要取最小值即可。
 * 第一层循环是字符串的总长度，第二层循环是从首字母开始到i判断是否为回文，如果是回文的话，就跟result[i+1]进行比较，选较小的即可
 *
 */
public class P132PalindromePartitioningII {

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] result = new int[s.length() + 1];
        result[0] = 0;
        boolean[][] dicts = getDicts(s);

        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = i + 1;
            for (int j = 0; j <=i; j++) {
                if (dicts[j][i]) {//二维矩形对角线上半部分
                    result[i + 1] = Math.min(result[i + 1], result[j] + 1);
                }
            }
        }
        return result[s.length()] - 1;
    }

    private boolean[][] getDicts(String s) {
        boolean[][] dicts = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dicts[i + 1][j - 1])) {
                    dicts[i][j] = true;
                }
            }
        }
        return dicts;
    }

    public static void main(String[] args){
        System.out.println(new P132PalindromePartitioningII().minCut("aab"));
    }

}
