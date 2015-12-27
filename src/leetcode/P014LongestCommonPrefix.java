package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p/>
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/3
 * Time: 下午5:08
 */
public class P014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        char pre = '0';
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    pre = strs[j].charAt(i);
                    continue;
                }
                if (pre != strs[j].charAt(i)) {
                    return strs[j].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLength);
    }

    public static void main(String[] args){
        System.out.println(new P014LongestCommonPrefix().longestCommonPrefix(new String[]{"123","1","176"}));
        System.out.println(new P014LongestCommonPrefix().longestCommonPrefix(new String[]{"23","1","176"}));
        System.out.println(new P014LongestCommonPrefix().longestCommonPrefix(new String[]{"123","12","12"}));
        System.out.println("123".substring(0,0));
    }


}
