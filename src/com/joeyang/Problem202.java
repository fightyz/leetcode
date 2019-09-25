package com.joeyang;

public class Problem202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = bitSum(n);
        while (slow != fast) {
            slow = fast;
            fast = bitSum(fast);
        }
        return slow == 1;
    }

    private int bitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
