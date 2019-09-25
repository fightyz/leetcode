package com.joeyang;

public class Problem1089 {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int slow = 0;
        int fast = 0;
        while (fast < length) {
            if (arr[slow] == 0) {
                fast++;
            }
            slow++;
            fast++;
        }
        slow--; // slow 回到最后一次合法的位置
        fast--; // fast 同理，但 fast 仍可能等于 length（例如输入 [0]）
        while (slow >= 0) {
            if (fast < length) {
                arr[fast] = arr[slow];
            }
            if (arr[slow] == 0) {
                arr[--fast] = arr[slow];
            }
            slow--;
            fast--;
        }
    }
}
