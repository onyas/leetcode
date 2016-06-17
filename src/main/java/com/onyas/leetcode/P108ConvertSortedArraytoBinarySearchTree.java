package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/15
 * Time: 上午9:38
 * <p/>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (M) Convert Sorted List to Binary Search Tree
 * Have you met this question in a real interview? Yes  No
 * Discuss
 */
public class P108ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = recursion(nums, start, middle - 1);
        root.right = recursion(nums, middle + 1, end);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new P108ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
    }
}
