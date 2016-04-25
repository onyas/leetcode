package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/18
 * Time: 上午9:28
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p/>
 * 熟悉卡特兰数的朋友可能已经发现了，这正是卡特兰数的一种定义方式，是一个典型的动态规划的定义方式（根据其实条件和递推式求解结果）。
 * 所以思路也很明确了，维护量res[i]表示含有i个结点的二叉查找树的数量。根据上述递推式依次求出1到n的的结果即可。
 * 时间上每次求解i个结点的二叉查找树数量的需要一个i步的循环，总体要求n次，所以总时间复杂度是O(1+2+...+n)=O(n^2)。
 * 空间上需要一个数组来维护，并且需要前i个的所有信息，所以是O(n)。
 * 当然这道题还可以用卡特兰数的通项公式来求解，这样时间复杂度就可以降低到O(n)。因为比较直接，这里就不列举代码了。
 */
public class P096UniqueBinarySearchTrees {

    public int numTrees(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }

        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new P096UniqueBinarySearchTrees().numTrees(3));
    }
}
