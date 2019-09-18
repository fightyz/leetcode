package com.joeyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsInOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> dfsInOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            results.add(cur.val);
            cur = cur.right;
        }
        return results;
    }
}
