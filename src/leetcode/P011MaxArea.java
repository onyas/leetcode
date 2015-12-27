package leetcode;

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
