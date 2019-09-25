package com.joeyang;

public class Problem121 {
    public int maxProfit(int[] prices) {
//        int buy = Integer.MAX_VALUE;
//        int sale = Integer.MIN_VALUE;

        int result = 0;
        int buy = 0;
        int sale = 0;
        int saleIndex = -1;
        for (int i = 0; i < prices.length; i++) {
            if (saleIndex > 0 && prices[i] >= buy) {
                continue;
            }
            if (prices[i] < buy && i <= saleIndex) {
                result = sale - prices[i];
                buy = prices[i];
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > result) {
                    result = prices[j] - prices[i];
                    saleIndex = j;
                    buy = prices[i];
                    sale = prices[j];
                }
            }
        }
        return result;
    }
}
