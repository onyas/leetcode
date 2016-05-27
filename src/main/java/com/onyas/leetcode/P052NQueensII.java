package com.onyas.leetcode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/27
 * Time: 上午9:45
 * <p/>
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * Subscribe to see which companies asked this question
 * Hide Tags Backtracking
 * Hide Similar Problems (H) N-Queens
 */
public class P052NQueensII {

    public int totalNQueens(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        helper(n, 0, new int[n], result);
        return result.get(0);
    }

    private void helper(int n, int row, int[] columnForRow, ArrayList<Integer> result) {
        if (n == row) {
            result.set(0, result.get(0) + 1);
            return;
        }

        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                helper(n, row + 1, columnForRow, result);
            }
        }
    }

    private boolean check(int row, int[] columnForRow) {
        for (int i = 0; i < row; i++) {
            if (columnForRow[i] == columnForRow[row]
                    || (Math.abs(columnForRow[row] - columnForRow[i])) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P052NQueensII().totalNQueens(8));
    }

}
