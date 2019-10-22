package com.joeyang;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int lastElement = 0;
        int lastIndex = nums.length - 1;
        int beginIndex = (lastIndex - 1) >> 1;

        /**
         * 第一步创建大顶堆
         */
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(nums, i, lastIndex);
        }

        /**
         * 第二步，对大顶堆进行调整：每次将大顶堆的根节点与未排序部分最后一个节点进行交换，
         * 然后调整树结构使其再次成为大顶堆
         */
        for (int i = lastIndex; i >= 0; i--) {
            System.out.println("max heap " + Arrays.stream(nums).boxed().collect(Collectors.toList()));
            System.out.println("cur max " + nums[0] + ", last max " + lastElement + ", last index " + i);
            if (nums[0] == lastElement) {
                return true;
            }
            lastElement = nums[0];
            swap(nums, 0, i);
            maxHeapify(nums, 0, i - 1);
        }
        return false;
    }

    private void maxHeapify(int[] array, int index, int lastIndex) {
        int leftChildIndex = (index << 1) + 1;
        int rightChildIndex = leftChildIndex + 1;
        int maxChildIndex = leftChildIndex; // 子节点值最大索引，默认左子节点
        if (leftChildIndex > lastIndex) {
            return; // 左子节点索引超出计算范围，直接返回
        }
        if (rightChildIndex <= lastIndex && array[rightChildIndex] > array[leftChildIndex]) { // 先判断左右子节点哪个大
            maxChildIndex = rightChildIndex;
        }
        if (array[maxChildIndex] > array[index]) { // 子节点有一个比根节点大
            swap(array, maxChildIndex, index);
            maxHeapify(array, maxChildIndex, lastIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
