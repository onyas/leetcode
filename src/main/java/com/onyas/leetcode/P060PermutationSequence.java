package com.onyas.leetcode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/24
 * Time: 上午9:17
 * <p/>
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * Subscribe to see which companies asked this question
 * Hide Tags Backtracking Math
 * Hide Similar Problems (M) Next Permutation (M) Permutations
 * <p/>
 * 我们以n = 4，k = 17为例，数组src = [1,2,3,...,n]。
 * 第17个排列的第一个数是什么呢：我们知道以某个数固定开头的排列个数 = (n-1)! = 3! = 6, 即以1和2开头的排列总共6*2 = 12个，12 < 17,
 * 因此第17个排列的第一个数不可能是1或者2，6*3 > 17, 因此第17个排列的第一个数是3。即第17个排列的第一个数是原数组（原数组递增有序）
 * 的第m = upper(17/6) = 3（upper表示向上取整）个数。
 * 第一个数固定后，我们从src数组中删除该数，那么就相当于在当前src的基础上求第k - (m-1)*(n-1)! = 17 - 2*6 = 5个排列，因此可以递归的求解该问题。
 */
public class P060PermutationSequence {

    public String getPermutation(int n, int k) {

        //init
        ArrayList<Integer> datas = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++) {
            datas.add(i);
        }

        // change k to be index
        k--;

        //n!
        int mod = 1;
        for (int i = 2; i <= n; i++) {
            mod *= i;
        }

        StringBuffer result = new StringBuffer();

        //循环，每次确定一个数，所以mod/(n-i)，第一个数就是 mod/n=(n-1)!  依次类推
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int index = k / mod;
            k %= mod;

            result.append(datas.get(index));

            datas.remove(index);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P060PermutationSequence().getPermutation(3, 2));
    }
}
