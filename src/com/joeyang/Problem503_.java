package com.joeyang;

import java.util.Stack;

/**
 * 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem503_ {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = -1; // -1 表示未找到
        }
        // 一个从栈底到栈顶单调递减的 单调栈。
        // 当一个数 > 栈顶时，则栈顶找到它的目标值，栈顶退栈，继续比较下一个数，直到该数找到他的位置（栈空时，它自己入栈）
        // 当一个数 <= 栈顶时，则栈中所有数都没有找到目标值，将该数入栈
        Stack<Integer> decreasingStack = new Stack<>();
        // 这里要遍历数组两轮才能找到所有值
        for (int i = 0; i < size * 2; i++) {
            // 栈不为空，且当前值 > 栈顶，则退栈顶，并且栈顶的目标值即为当前值
            int curIndex = i % size;
            int curValue = nums[curIndex];
            while (!decreasingStack.empty() && nums[decreasingStack.peek()] < curValue) {
                Integer targetIndex = decreasingStack.pop();
                result[targetIndex] = curValue;
            }
            decreasingStack.push(curIndex);
        }
        // 经过两轮遍历后，有目标值的都应该已经在上面被更新过了，因此直接返回 result
        return result;
    }
}
