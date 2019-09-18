package com.joeyang;

import java.util.Stack;

public class Problem538 {
    public TreeNode convertBST(TreeNode root) {
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        head = head.left;
        while (!stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            head = head.right;

        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
