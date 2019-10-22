package com.joeyang.sort;

public class HeapSort {
    /**
     * 堆排序的主要入口方法，共两步
     */
    public void sort(int[] array) {
        int lastIndex = array.length - 1;
        int beginIndex = (lastIndex - 1) >> 1;
        /**
         * 第一步创建大顶堆
         */
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(array, i, lastIndex);
        }

        /**
         * 第二部，对大顶堆进行调整：每次将大顶堆的根节点与未排序部分最后一个节点进行交换，
         * 然后调整树结构使其再次成为大顶堆
         */
        for (int i = lastIndex; i > 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, 0, i - 1);
        }
    }

    /**
     * 将以 index 为根的树调整为大顶堆
     * @param array
     * @param index
     * @param lastIndex
     */
    private void maxHeapify(int[] array, int index, int lastIndex) {
        int leftChildIndex = (index << 1) + 1;
        int rightChildIndex = leftChildIndex + 1;
        int maxChildIndex = leftChildIndex; // 子节点值最大索引，默认左子节点
        if (leftChildIndex > lastIndex) {
            return; // 左子节点索引超出计算范围，直接返回
        }
        if (rightChildIndex <= lastIndex && array[rightChildIndex] >  array[leftChildIndex]) { // 先判断左右子节点哪个大
            maxChildIndex = rightChildIndex;
        }
        if (array[maxChildIndex] >  array[index]) { // 子节点有一个比根节点大
            swap(array, maxChildIndex, index); // 交换最大子节点和根节点
            maxHeapify(array, maxChildIndex, lastIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
