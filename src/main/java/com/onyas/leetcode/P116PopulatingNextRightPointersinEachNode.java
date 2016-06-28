package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/20
 * Time: 上午9:04
 * <p/>
 * Given a binary tree
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 * Subscribe to see which companies asked this question
 * Hide Tags Tree Depth-first Search
 * Hide Similar Problems (H) Populating Next Right Pointers in Each Node II (M) Binary Tree Right Side View
 *
 * 用两个指针分别表示上一层和下一层；
 */
public class P116PopulatingNextRightPointersinEachNode {


    public void connect(TreeLinkNode root) {
        if(root==null){
            return ;
        }
        TreeLinkNode parent = root;
        TreeLinkNode nextLevel =  parent.left;
        while(parent!=null && nextLevel !=null){

            TreeLinkNode pre = null;
            while(parent!=null){
                if(pre==null){
                    pre = parent.left;
                }else{
                    pre.next = parent.left;
                    pre  = pre.next;
                }
                pre.next = parent.right;
                pre = pre.next;
                parent = parent.next;
            }

            parent = nextLevel;
            nextLevel = parent.left;
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
        System.out.println(new P116PopulatingNextRightPointersinEachNode());
    }
}
