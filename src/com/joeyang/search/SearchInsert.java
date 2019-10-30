package com.joeyang.search;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        // 如果 target 比 nums 里所有的数都大，则最后一个数的索引 + 1 就是候选值，因此，右边界应该是数组长度
        int right = len;
        // 二分的逻辑一定要写对，否则会出现死循环或者数组下标越界
        while (left < right) {
            int mid = (left + right) >>> 1; // 选取左中位数（在 left ~ right 区间中的左中位数）
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
