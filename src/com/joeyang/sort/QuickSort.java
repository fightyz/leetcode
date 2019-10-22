package com.joeyang.sort;

public class QuickSort {

    private void quickSort(int s[], int l, int r) {
        if (l < r) {
            int i = adjustArray(s, l, r);
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    /**
     * 返回调整后基准数的位置
     * @param s 代派数组
     * @param l 数组第一个 index
     * @param r 数组最后一个 index
     * @return 调整后基准数的位置
     */
    private int adjustArray(int s[], int l, int r) {
        int i = l, j = r;
        int x = s[l]; // 左边第一个坑
        while (i < j) { // 退出条件
            // 从右向左找小于 x 的数来填坑
            while (i < j && s[j] >= x) {
                j--;
            }
            if (i < j) {
                s[i] = s[j];
                i++;
            }

            // 从左向右找大于或等于 x 的数来填 s[j]
            while (i <j && s[i] < x) {
                i++;
            }
            if (i < j) {
                s[j] = s[i];
                j--;
            }
        }
        s[i] = x;
        return i;
    }
}
