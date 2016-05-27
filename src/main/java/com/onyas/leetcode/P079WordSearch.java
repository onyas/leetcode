package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/26
 * Time: 上午9:26
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class P079WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] uesed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, i, j, uesed)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int index, int i, int j, boolean[][] uesed) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || uesed[i][j] ||
                board[i][j] != word.charAt(index)) {
            return false;
        }

        uesed[i][j] = true;
        boolean result = search(board, word, index + 1, i, j - 1, uesed)
                || search(board, word, index + 1, i, j + 1, uesed)
                || search(board, word, index + 1, i - 1, j, uesed)
                || search(board, word, index + 1, i + 1, j, uesed);
        uesed[i][j] = false;

        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};
        System.out.println(new P079WordSearch().exist(board, "ABCCED"));
        System.out.println(new P079WordSearch().exist(board, "SEE"));
        System.out.println(new P079WordSearch().exist(board, "ABCB"));
    }

}
