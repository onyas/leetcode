package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/22
 * Time: 上午9:06
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of
 * the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p/>
 * 思路：就是res[i][j]=res[i-1][j]+res[i][j-1]，这样我们就可以用一个数组来保存历史信息，也就是在i行j列的路径数，这样每次就不需要重复计算，
 * 从而降低复杂度。用动态规划我们只需要对所有格子进行扫描一次，到了最后一个得到的结果就是总的路径数，所以时间复杂度是O(m*n)。
 * 而对于空间可以看出我们每次只需要用到上一行当前列，以及前一列当前行的信息，我们只需要用一个一维数组存上一行的信息即可，然后扫过来依次更替掉上一行对应列的信息即可
 * （因为所需要用到的信息都还没被更替掉），所以空间复杂度是O(n)（其实如果要更加严谨，我们可以去行和列中小的那个，然后把小的放在内层循环，这样空间复杂度就是O(min(m,n))，
 * 下面的代码为了避免看起来过于繁杂，就不做这一步了，有兴趣的朋友可以实现一下，比较简单，不过代码有点啰嗦）。
 * <p/>
 * 另一种实现方法，可参考卡特兰数
 */
public class P062UniquePaths {

    public int uniquePaths(int m, int n) {

        if (n < 0 || m < 0) {
            return 0;
        }

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new P062UniquePaths().uniquePaths(3, 3));
    }

}
