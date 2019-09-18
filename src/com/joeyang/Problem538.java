package com.joeyang;

import java.util.Stack;

public class Problem538 {
    public TreeNode convertBST(TreeNode root) {
        int last = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += last;
            last = cur.val;
            cur = cur.left;
        }
        return root;
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
