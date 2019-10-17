package com.joeyang;

import java.util.Stack;

public class Problem783 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDiffInBST(TreeNode root) {
        boolean first = false;
        int small = 0;
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (!first) {
                first = true;
                small = cur.val;
//                System.out.println("first " + small);
            } else {
//                System.out.println("val " + cur.val + ", small " + small);
                int abs = Math.abs(cur.val - small);
                if (abs < result) {
                    result = abs;
                }
                small = cur.val;
            }
            cur = cur.right;
        }
        return result;
    }
}
