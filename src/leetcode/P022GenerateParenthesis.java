package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/4
 * Time: 下午8:01
 */
public class P022GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> resutl = new ArrayList<String>();
        dfs(resutl, "", n, n);
        return resutl;
    }

    /**
     * left,right means how many symbols like '(' and ')' to be added
     * @param resutl
     * @param s
     * @param left
     * @param right
     */
    private void dfs(ArrayList<String> resutl, String s, int left, int right) {
        if (left > right) {//when left > right,meaningless,so stop
            return;
        }
        if (left == 0 && right == 0) {
            resutl.add(s);
            return;
        }
        if (left > 0) {
            dfs(resutl, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(resutl, s + ")", left, right - 1);
        }
    }


    public static void main(String[] args){
        System.out.println(new P022GenerateParenthesis().generateParenthesis(3));
    }
}
