package com.onyas.leetcode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/18
 * Time: 上午9:38
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * <p/>
 * 思路跟Longest Valid Parentheses比较类似，我们要维护一个栈，这个栈从低向上的高度是依次递增的，如果遇到当前bar高度比栈顶元素低，
 * 那么就出栈直到满足条件，过程中检测前面满足条件的矩阵。关键问题就在于在出栈时如何确定当前出栈元素的所对应的高度的最大范围是多少。
 * 答案跟Longest Valid Parentheses中括号的范围相似，就是如果栈已经为空，说明到目前为止所有元素（当前下标元素除外）都比出栈元素高度要大（否则栈中肯定还有元素），
 * 所以矩阵面积就是高度乘以当前下标i。如果栈不为空，那么就是从当前栈顶元素的下一个到当前下标的元素之前都比出栈元素高度大（因为栈顶元素第一个比当前出栈元素小的）
 * 时间复杂度是O(n)，空间复杂度是栈的大小，最坏情况是O(n)。
 */
public class P084LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P084LargestRectangleinHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
