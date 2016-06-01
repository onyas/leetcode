package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/16
 * Time: 下午4:36
 * <p/>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * ...and its solution numbers marked in red.
 *
 *
 * 这道题的方法就是用在N-Queens中介绍的常见套路。简单地说思路就是循环处理子问题，对于每个格子，带入不同的9个数，
 * 然后判合法，如果成立就递归继续，结束后把数字设回空。大家可以看出代码结构和N-Queens是完全一样的。判合法可以用Valid Sudoku做为subroutine，
 * 但是其实在这里因为每次进入时已经保证之前的board不会冲突，所以不需要判断整个盘，只需要看当前加入的数字和之前是否冲突就可以，
 * 这样可以大大提高运行效率，毕竟判合法在程序中被多次调用。
 *
 */
public class P037SudokuSolver {

    public void solveSudoku(char[][] board) {

        if (board == null || board.length != 9
                || board[0].length != 9) {
            return;
        }

        helper(board, 0, 0);

    }

    private boolean helper(char[][] board, int i, int j) {

        if (j >= 9) {
            return helper(board, i + 1, 0);
        }

        if (i == 9) {
            return true;
        }

        if (board[i][j] == '.') {

            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    if (helper(board, i, j + 1)) {
                        return true;
                    }
                }
                board[i][j] = '.';
            }

        } else {
            return helper(board, i, j + 1);
        }
        return false;

    }

    private boolean isValid(char[][] board, int i, int j) {

        for (int k = 0; k < 9; k++) {
            if (k != i && (board[k][j] == board[i][j])) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (k != j && (board[i][k] == board[i][j])) {
                return false;
            }
        }

        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j)
                        && (board[row][col] == board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] target = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '.', '2', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        new P037SudokuSolver().solveSudoku(target);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(target[i][j]);
            }
            System.out.println();
        }
    }
}
