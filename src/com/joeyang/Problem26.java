package com.joeyang;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;

        while (fast != nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                fast++;
            }
        }
        return slow + 1;
    }
}
