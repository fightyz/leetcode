package com.joeyang;

public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}
