package com.joeyang;

public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = 0;
        for (;end < nums.length; end++) {
            if (nums[end] == val) {
                continue;
            }
            nums[start++] = nums[end];
        }
        return start;
    }
}
