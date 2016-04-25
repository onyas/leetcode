package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/19
 * Time: 上午8:53
 * <p/>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p/>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * 思路是维护到某一个元素的最小路径和，那么在某一个元素i，j的最小路径和就是它上层对应的相邻两个元素的最小路径和加上自己的值，
 * 递推式是sum[i][j]=min(sum[i-1][j-1],sum[i-1][j])+triangle[i][j]。最后扫描一遍最后一层的路径和，取出最小的即可。
 * 每个元素需要维护一次，总共有1+2+...+n=n*(n+1)/2个元素，所以时间复杂度是O(n^2)。而空间上每次只需维护一层即可（因为当前层只用到上一层的元素），
 * 所以空间复杂度是O(n),这是自顶向下的处理方式。同理，自底向上也是同样的道理，递归式只是变成下一层对应的相邻两个元素的最小路径和加上自己的值。
 */
public class P120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null) {
            return 0;
        }

        int result[] = new int[triangle.size()];

        //初始化为最底下的一行
        for (int i = 0; i < triangle.size(); i++) {
            result[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
            }
        }

        return result[0];
    }


    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(2);
        triangle.add(zero);
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(3);
        first.add(4);
        triangle.add(first);
        ArrayList<Integer> seconde = new ArrayList<Integer>();
        seconde.add(6);
        seconde.add(5);
        seconde.add(7);
        triangle.add(seconde);
        ArrayList<Integer> third = new ArrayList<Integer>();
        third.add(4);
        third.add(1);
        third.add(8);
        third.add(3);
        triangle.add(third);

        System.out.println(new P120Triangle().minimumTotal(triangle));
    }
}
