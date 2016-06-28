package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/13
 * Time: 上午8:50
 * <p/>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p/>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p/>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p/>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * <p/>
 * <p/>
 * 主要思想就是一句话：用一个循环递归处理子问题。这个问题中，在每一层递归函数中，我们用一个循环把一个皇后填入对应行的某一列中，
 * 如果当前棋盘合法，我们就递归处理下一行，找到正确的棋盘我们就存储到结果集里面。
 * 这种题目都是使用这个套路，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除，
 * 这道题目中不用移除的原因是我们用一个一维数组去存皇后在对应行的哪一列，因为一行只能有一个皇后，如果二维数组，
 * 那么就需要把那一行那一列在递归结束后设回没有皇后，所以道理是一样的。
 */
public class P051NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<List<String>>();
        helper(n, 0, new int[n], res);

        return res;
    }

    private void helper(int n, int row, int[] columnForRow, List<List<String>> res) {
        //如果已经到最后一行了，说明这个是正确的queen
        if (n == row) {
            List<String> items = new ArrayList<String>(n);
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (columnForRow[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                items.add(sb.toString());
            }
            res.add(items);
            return;
        }

        //在循环里面调用递归
        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                helper(n, row + 1, columnForRow, res);
            }
        }
    }

    //在检查的时候，因为之前的行肯定都是正确的，所以只需要比较当前行的元素跟之前行的元素是不是在同一列上，还有是不是在对角线上
    private boolean check(int row, int[] columnForRow) {

        for (int i = 0; i < row; i++) {
            if (columnForRow[row] == columnForRow[i] ||
                    Math.abs(columnForRow[row] - columnForRow[i]) == row - i) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        List<List<String>> result = new P051NQueens().solveNQueens(4);
        for (List<String> strings : result) {
            for (String s : strings) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
