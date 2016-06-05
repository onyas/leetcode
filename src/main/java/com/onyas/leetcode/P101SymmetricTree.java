package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/2
 * Time: 上午8:31
 * <p/>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search Breadth-first Search
 * <p/>
 * 这里无所谓哪种遍历方式，只需要对相应结点进行比较即可。一颗树对称其实就是看左右子树是否对称，一句话就是左同右，右同左，结点是对称的相等。
 * 这道题目也就是里面的程序框架加上对称性质的判断即可。遍历这里就不多说了，我们主要说说结束条件，假设到了某一结点，不对称的条件有以下三个：
 * （1）左边为空而右边不为空；（2）左边不为空而右边为空；（3）左边值不等于右边值。根据这几个条件在遍历时进行判断即可。
 * 算法的时间复杂度是树的遍历O(n)，空间复杂度同样与树遍历相同是O(logn)。
 */
public class P101SymmetricTree {


    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return recursion(left.right, right.left) && recursion(left.left, right.right);
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
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        System.out.println(new P101SymmetricTree().isSymmetric(root));
    }
}
