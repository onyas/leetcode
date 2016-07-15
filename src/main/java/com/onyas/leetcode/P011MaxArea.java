package com.onyas.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * <p/>
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/3
 * Time: 下午2:33
 * <p/>
 * 从数组两端走起，每次迭代时判断左pointer和右pointer指向的数字哪个大，如果左pointer小，意味着向左移动右pointer不可能使结果变得更好，
 * 因为瓶颈在左pointer，移动右pointer只会变小，所以这时候我们选择左pointer右移。反之，则选择右pointer左移。在这个过程中一直维护最大的那个容积。代码如下：
 */
public class P011MaxArea {

    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int leftHeight = 0;
        int rightHeight = height.length - 1;
        while (leftHeight < rightHeight) {
            max = Math.max(max, (rightHeight - leftHeight) * Math.min(height[rightHeight], height[leftHeight]));
            if (height[rightHeight] < height[leftHeight]) {
                rightHeight--;
            } else {
                leftHeight++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P011MaxArea().maxArea(new int[]{1, 2, 3, 4}));
        System.out.println(new P011MaxArea().maxArea(new int[]{1, 100, 3, 4}));
    }

}
