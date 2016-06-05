package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/4
 * Time: 上午11:23
 * <p/>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Depth-first Search Breadth-first Search Union Find
 * Hide Similar Problems (M) Surrounded Regions (M) Walls and Gates (H) Number of Islands II (M) Number of Connected Components in an Undirected Graph
 */
public class P200NumberofIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    removeIsland(grid, '1', '0', i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void removeIsland(char[][] grid, char fromColor, char toColor, int i, int j) {
        char currentColor = getValueAt(grid, i, j);
        if (currentColor == fromColor) {
            grid[i][j] = toColor;
            removeIsland(grid, fromColor, toColor, i - 1, j);
            removeIsland(grid, fromColor, toColor, i + 1, j);
            removeIsland(grid, fromColor, toColor, i, j + 1);
            removeIsland(grid, fromColor, toColor, i, j - 1);
        }
    }

    private char getValueAt(char[][] picture, int x, int y) {
        if (x < 0 || y < 0 || x >= picture.length || y >= picture[x].length) {
            return '9';
        } else {
            return picture[x][y];
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[4][5];
        board[0] = new char[]{'1', '1', '1', '1', '0'};
        board[1] = new char[]{'1', '1', 'O', '1', '1'};
        board[2] = new char[]{'1', '1', 'O', '0', '0'};
        board[3] = new char[]{'0', 'O', '0', '0', '0'};

        char[][] board1 = new char[4][5];
        board1[0] = new char[]{'1', '1', '0', '0', '0'};
        board1[1] = new char[]{'1', '1', 'O', '0', '0'};
        board1[2] = new char[]{'0', '0', '1', '0', '0'};
        board1[3] = new char[]{'0', 'O', '0', '1', '1'};

        System.out.println(new P200NumberofIslands().numIslands(board));
        System.out.println(new P200NumberofIslands().numIslands(board1));
    }

}
