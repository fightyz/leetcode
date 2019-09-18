package com.joeyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsPreOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> dfsPreOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                results.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // 转向
            cur = cur.right;
        }
        return results;
    }
}
