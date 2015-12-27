package leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/4
 * Time: 下午5:24
 */
public class P020ValidParentheses {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> characters = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                characters.add(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (!characters.isEmpty()) {
                    Character target = characters.pop();
                    if ((s.charAt(i) == ')' && target != '(') || (s.charAt(i) == '}' && target != '{')
                            || (s.charAt(i) == ']' && target != '[')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

}
