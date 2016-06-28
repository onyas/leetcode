package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/20
 * Time: 上午9:15
 * <p/>
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (M) Populating Next Right Pointers in Each Node
 */
public class P117PopulatingNextRightPointersinEachNodeII {


    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;
        TreeLinkNode nextLevel;
        TreeLinkNode pre;

        while (parent != null) {
            nextLevel = null;
            pre = null;

            while (parent != null) {
                if (nextLevel == null) {
                    nextLevel = parent.left != null ? parent.left : parent.right;
                }

                if(parent.left!=null){
                    if(pre==null){
                        pre = parent.left;
                    }else{
                        pre.next = parent.left;
                        pre = pre.next;
                    }
                }

                if(parent.right!=null){
                    if(pre == null){
                        pre = parent.right;
                    }else{
                        pre.next = parent.right;
                        pre = pre.next;
                    }
                }

                parent = parent.next;
            }
            parent = nextLevel;
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
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

    public static void main(String[] args){
        System.out.println(new P117PopulatingNextRightPointersinEachNodeII());
    }
}
