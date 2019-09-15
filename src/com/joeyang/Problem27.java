package com.joeyang;

public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        boolean foundPivot = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[length - 1];
                nums[length - 1] = tmp;
                foundPivot = true;
                break;
            }
        }
        if (!foundPivot) {
            return nums.length;
        }

        int start = 0;
        int end = length - 1;
        while (start < end) {
            while (start < end && nums[start] != val) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
                end--;
            }

            while (start < end && nums[end] == val) {
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
                start++;
            }
        }
        nums[start] = val;

        int count = 0;
        for (int i = 0; i < end; i++) {
            if (nums[i] != val) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
