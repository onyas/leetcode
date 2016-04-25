package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/4/20
 * Time: 上午9:55
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class P122BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                diff += prices[i] - prices[i-1];
            }
        }
        return diff;
    }


    public static void main(String[] args){
        System.out.println(new P122BestTimetoBuyandSellStockII().maxProfit(new int[]{1,2,3,2,4}));
        System.out.println(new P122BestTimetoBuyandSellStockII().maxProfit(new int[]{2,1,4}));
    }
}
