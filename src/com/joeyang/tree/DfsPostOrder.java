package com.joeyang.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsPostOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> dfsPostOrder(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == last) {
                results.add(cur.val);
                stack.pop();
                // 记录上一个访问的节点
                // 用于判断"访问根节点之前，右子树是否已访问过"
                last = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return results;
    }
}
