package com.joeyang;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem561 {
    public int arrayPairSum(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    private void quickSort(int[] nums, int l, int r) {
        int pivot = adjustArray(nums, 0, nums.length - 1);
        quickSort(nums, 0, pivot - 1);
        quickSort(nums, pivot + 1, nums.length);
    }

    private int adjustArray(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
                start++;
            }
            while (start < end && nums[start] < pivot) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
                end--;
            }
        }
        nums[start] = pivot;
        return start;
    }
}
