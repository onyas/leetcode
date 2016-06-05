package com.onyas.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/4
 * Time: 上午10:46
 * <p/>
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Subscribe to see which companies asked this question
 * Hide Tags Breadth-first Search Union Find
 * Hide Similar Problems (M) Number of Islands (M) Walls and Gates
 */
public class P130SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 ||
                board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < rows; i++) {
            enqueue(queue, board, i, 0);
            enqueue(queue, board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            enqueue(queue, board, 0, j);
            enqueue(queue, board, rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                    y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = '#';
            }

            enqueue(queue, board, x - 1, y);
            enqueue(queue, board, x + 1, y);
            enqueue(queue, board, x, y - 1);
            enqueue(queue, board, x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void enqueue(Queue<Integer> queue, char[][] board, int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O') {
            queue.offer(x * cols + y);
        }
    }


    public static void main(String[] args) {

        char[][] board = new char[4][4];
        board[0] = new char[]{'X', 'X', 'X', 'X',};
        board[1] = new char[]{'X', 'O', 'O', 'X',};
        board[2] = new char[]{'X', 'X', 'O', 'X',};
        board[3] = new char[]{'X', 'O', 'X', 'X',};

        new P130SurroundedRegions().solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


}
