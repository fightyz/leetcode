package com.joeyang;

public class Problem1011 {
    public int shipWithinDays(int[] weights, int D) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            max += weights[i];
            if (weights[i] > min) {
                min = weights[i];
            }
        }

        while (min < max) {
            int mid = (min + max) >>> 1;
            int days = calculateDays(weights, mid);
            if (days > D) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    private int calculateDays(int[] weights, int cap) {
        int days = 0;
        int remain = cap;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= remain) {
                remain -= weights[i];
            } else {
                days++;
                remain = cap - weights[i];
            }
        }
        return ++days;
    }
}
