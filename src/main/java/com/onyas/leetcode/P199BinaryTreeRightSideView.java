package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/17
 * Time: 上午9:28
 * <p/>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 * Credits:
 * Special thanks to @amrsaqr for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search Breadth-first Search
 * Hide Similar Problems (M) Populating Next Right Pointers in Each Node
 *
 * 思路：广度优先的时候，每次先放右边的树，这样循环的时候第一次出队的就是最右边的。
 */
public class P199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.remove();
                if (i == 0) {
                    result.add(tree.val);
                }
                if (tree.right != null) {
                    queue.add(tree.right);
                }
                if (tree.left != null) {
                    queue.add(tree.left);
                }
            }
        }

        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        System.out.println(new P199BinaryTreeRightSideView());
    }
}
