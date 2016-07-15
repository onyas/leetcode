package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/15
 * Time: 上午9:00
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap
 * after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being
 * trapped. Thanks Marcos for contributing this image!
 * Subscribe to see which companies asked this question
 * Hide Tags Array Stack Two Pointers
 * Hide Similar Problems (M) Container With Most Water (M) Product of Array Except Self
 * <p/>
 * 用两个指针从两端往中间扫，在当前窗口下，如果哪一侧的高度是小的，那么从这里开始继续扫，如果比它还小的，肯定装水的瓶颈就是它了，可以把装水量加入结果，
 * 如果遇到比它大的，立即停止，重新判断左右窗口的大小情况，重复上面的步骤。这里能作为停下来判断的窗口，说明肯定比前面的大了，所以目前肯定装不了水（
 * 不然前面会直接扫过去）。这样当左右窗口相遇时，就可以结束了，因为每个元素的装水量都已经记录过了
 */
public class P042TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            if (height[left] == min) {
                left++;
                while (left < right && height[left] < min) {
                    result += min - height[left];
                    left++;
                }
            } else {
                right--;
                while (left < right && height[right] < min) {
                    result += min - height[right];
                    right--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new P042TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
