package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/20
 * Time: 上午9:48
 * <p/>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p/>
 * 给一个数组prices[]，prices[i]代表股票在第i天的售价，求出只做一次交易(一次买入和卖出)能得到的最大收益。
 * 只需要找出最大的差值即可，即 max(prices[j] – prices[i]) ，i < j。一次遍历即可，在遍历的时间用遍历low记录 prices[o....i] 中的最小值，
 * 就是当前为止的最低售价，时间复杂度为 O(n)。
 */
public class P121BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int diff = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            if (prices[i] - low > diff) {
                diff = prices[i] - low;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(new P121BestTimetoBuyandSellStock().maxProfit(new int[]{1, 2, 39}));
    }
}
