package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/19
 * Time: 上午9:34
 * <p/>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Dynamic Programming
 * Hide Similar Problems (M) Unique Binary Search Trees (M) Different Ways to Add Parentheses
 * <p/>
 * <p/>
 * 这道题是求解所有可行的二叉查找树，从Unique Binary Search Trees中我们已经知道，可行的二叉查找树的数量是相应的卡特兰数，不是一个多项式时间的数量级，
 * 所以我们要求解所有的树，自然是不能多项式时间内完成的了。算法上还是用求解NP问题的方法来求解，也就是N-Queens中介绍的在循环中调用递归函数求解子问题。
 * 思路是每次一次选取一个结点为根，然后递归求解左右子树的所有结果，最后根据左右子树的返回的所有子树，依次选取然后接上（每个左边的子树跟所有右边的子树匹配，
 * 而每个右边的子树也要跟所有的左边子树匹配，总共有左右子树数量的乘积种情况），构造好之后作为当前树的结果返回。代码如下：
 */
public class P095UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    private List<TreeNode> helper(int left, int right) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (left > right) {
            result.add(null);
            return result;
        }

        for (int i = left; i <= right; i++) {

            List<TreeNode> leftTrees = helper(left, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, right);

            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    result.add(root);
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

    public static void main(String[] args) {
        System.out.println(new P095UniqueBinarySearchTreesII().generateTrees(5).size());
    }
}
