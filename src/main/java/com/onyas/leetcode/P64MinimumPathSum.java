package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/13
 * Time: 上午8:45
 * <p/>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum
 * of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * <p/>
 * 题解：动态规划
 * 递推方程：sum[i][j] = min(sum[i-1][j],sum[i][j-1])+gird[i][j]
 */
public class P64MinimumPathSum {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int sum[][] = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[m - 1][n - 1];
    }


    public static void main(String[] args){
        System.out.println(new P64MinimumPathSum().minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}
