package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/16
 * Time: 下午6:07
 * <p/>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p/>
 * 斐波那契数列的非递归实现
 */
public class P070ClimbingStairs {

    public int climbStairs(int n) {

        if (n < 0) {
            return 0;
        }
        int result = 0;
        int step1 = 0, step2 = 1;
        for (int i = 1; i <= n; i++) {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new P070ClimbingStairs().climbStairs(1);
        System.out.println(result);
        result = new P070ClimbingStairs().climbStairs(2);
        System.out.println(result);
        result = new P070ClimbingStairs().climbStairs(3);
        System.out.println(result);
        result = new P070ClimbingStairs().climbStairs(4);
        System.out.println(result);
    }

}
