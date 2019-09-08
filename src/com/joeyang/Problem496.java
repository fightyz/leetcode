package com.joeyang;

import java.util.HashMap;
import java.util.Map;

public class Problem496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> valueByIndex = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            valueByIndex.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            Integer index = valueByIndex.get(value);
            int greater = findGreater(nums2, index, value);
            result[i] = greater;
        }
        return result;
    }

    private int findGreater(int[] values, int index, int value) {
        for (; index < values.length; index++) {
            if (values[index] > value) {
                return values[index];
            }
        }
        return -1;
    }
}
