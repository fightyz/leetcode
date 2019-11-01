package com.joeyang;

public class Problem875 {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        while (min < max) {
            System.out.println("min " + min + ", max " + max);
            int mid = (min + max) >>> 1;
            int round = calculateRound(mid, piles);
            System.out.println("round " + round);
            if (round > H) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    private int calculateRound(int mid, int[] piles) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % mid != 0) {
                count += piles[i] / mid + 1;
            } else {
                count += piles[i] / mid;
            }
        }
        return count;
    }
}
