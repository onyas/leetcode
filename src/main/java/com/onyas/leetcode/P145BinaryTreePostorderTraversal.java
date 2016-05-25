package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/25
 * Time: 上午9:46
 */
public class P145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && pre != peekNode.right) {
                    root = peekNode.right;
                } else {
                    stack.pop();
                    result.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        TreeNode left = new TreeNode(3);
        right.left = left;
        System.out.println(new P145BinaryTreePostorderTraversal().postorderTraversal(root));
        System.out.println(new P145BinaryTreePostorderTraversal().postorderTraversal1(root));
    }
}
