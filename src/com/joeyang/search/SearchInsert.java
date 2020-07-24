package com.joeyang.search;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 左右两个边界应该包含所有可能的结果。
        // 1. 如果 target 比 nums 里所有的数都小，则最后结果的索引一定是 0。因此左边界是 0.
        // 2. 如果 target 比 nums 里所有的数都大，则最后结果的索引一定是最后一个数的索引 + 1。因此右边界是 len
        int left = 0;
        int right = len;
        // 二分的逻辑一定要写对，否则会出现死循环或者数组下标越界
        while (left < right) {

            int mid = (left + right) >>> 1;

            // 这里之所以要使用 nums[mid] < target 条件，是因为只有这个条件下才能使范围收敛时
            // left 不等于 mid，而是 left = mid + 1。
            // 如果使用 target < nums[mid] 条件，那么范围收敛只能到 left = mid。而 mid 的计算是左中位数，
            // 这就可能出现计算出来的 mid 值就等于 left，因此收敛时 left 完全没有变，从而出现死循环。
            if (nums[mid] < target) {
                // 如果 target > nums[mid]，那么 target 最终插入的位置一定在 mid 右边，
                // 因此一定要 mid + 1 来将范围缩小。如果此时不排除 mid，则之后计算可能出现死循环
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
