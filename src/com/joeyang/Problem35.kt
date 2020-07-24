package com.joeyang

class Problem35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = (left + right) / 2
//            if (nums[mid] < target) {
//                left = mid + 1
//            } else {
//                right = mid
//            }
            if (target < nums[mid]) {
                right = mid
            } else {
                left = mid
            }
        }
        return left
    }
}