package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/29
 * Time: 上午9:52
 * <p/>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Binary Search
 * Hide Similar Problems (M) Search a 2D Matrix II
 */
public class P074Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            int row = middle / cols;
            int col = middle % cols;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (matrix[left / cols][left % cols] == target) {
            return true;
        } else if (matrix[right / cols][right % cols] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(new P074Searcha2DMatrix().searchMatrix(matrix, 3));
        System.out.println(new P074Searcha2DMatrix().searchMatrix(matrix, 10));
        System.out.println(new P074Searcha2DMatrix().searchMatrix(matrix, 8));

        int[][] matrix1 = {{1}};
        System.out.println(new P074Searcha2DMatrix().searchMatrix(matrix1, 1));
        int[][] matrix2 = {{1, 1}};
        System.out.println(new P074Searcha2DMatrix().searchMatrix(matrix2, 5));
        int[][] matrix3 = {{1, 3, 5}};
        System.out.println(new P074Searcha2DMatrix().searchMatrix(matrix3, 2));
    }

}
