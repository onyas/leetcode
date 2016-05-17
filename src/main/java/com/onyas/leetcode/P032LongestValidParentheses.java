package com.onyas.leetcode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/14
 * Time: 上午9:57
 */
public class P032LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int max = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    start = i+1;
                }else{
                    stack.pop();
                    max = stack.isEmpty()?Math.max(max, i - start + 1):Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new P032LongestValidParentheses().longestValidParentheses("(((("));
        System.out.println(new P032LongestValidParentheses().longestValidParentheses("(((())"));
        System.out.println(new P032LongestValidParentheses().longestValidParentheses("(((())(("));
    }

}
