package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/6
 * Time: 上午9:58
 * <p/>
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (M) Path Sum II
 */
public class P257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        recursion(root, result, String.valueOf(root.val));
        return result;
    }

    private void recursion(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }

        if(root.left==null && root.right==null){
            result.add(path);
            return;
        }

        if (root.left != null) {
            recursion(root.left, result, path + "->" + root.left.val);
        }

        if (root.right != null) {
            recursion(root.right, result, path + "->" + root.right.val);
        }

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
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        System.out.println(new P257BinaryTreePaths().binaryTreePaths(root));
    }
}
