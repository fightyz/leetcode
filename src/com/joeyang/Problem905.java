package com.joeyang;

public class Problem905 {
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int pivot = A[start];
        while (start < end) {
            while (start < end && isOdd(A[end])) {
                end--;
            }
            if (start < end) {
                A[start] = A[end];
                start++;
            }

            while (start < end && isEven(A[start])) {
                start++;
            }
            if (start < end) {
                A[end] = A[start];
                end--;
            }
        }
        A[start] = pivot;
        return A;
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }

    private boolean isOdd(int value) {
        return value % 2 == 1;
    }
}
