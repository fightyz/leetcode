package com.joeyang;

public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int peak = 0;
        int valley = 0;
        int total = 0;
        boolean buyed = false;
        for (int i = 0; i < prices.length; i++) {
            if (isValley(prices, i) && !buyed) {
                valley = prices[i];
                buyed = true;
                continue;
            }
            if (isPeak(prices, i) && buyed) {
                peak = prices[i];
                total += peak - valley;
                buyed = false;
                continue;
            }
        }
        return total;
    }

    private boolean isPeak(int[] prices, int index) {
        if (index == 0) {
            return prices[index + 1] <= prices[index];
        } else if (index == prices.length - 1) {
            return prices[index] >= prices[index - 1];
        }
        return prices[index - 1] <= prices[index] && prices[index] >= prices[index + 1];
    }

    private boolean isValley(int[] prices, int index) {
        if (index == 0) {
            return prices[index + 1] >= prices[index];
        } else if (index == prices.length - 1) {
            return prices[index] <= prices[index - 1];
        }
        return prices[index - 1] >= prices[index] && prices[index] <= prices[index + 1];
    }
}
