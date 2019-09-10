package com.joeyang;

public class Problem1122_ {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] nums = new int[1001];
        int[] res = new int[arr1.length];
        // 遍历 arr1，统计每个元素的数量
        for (int i : arr1) {
            nums[i]++;
        }
        // 遍历 arr2，处理 arr2 中出现的元素
        int index = 0;
        for (int i : arr2) {
            while (nums[i] > 0) {
                res[index++] = i;
                nums[i]--;
            }
        }
        // 遍历 nums，处理剩下 arr2 中未出现的元素
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0) {
                res[index++] = i;
                nums[i]--;
            }
        }
        return res;
    }
}
