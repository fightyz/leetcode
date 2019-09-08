package com.joeyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 */
public class Problem590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 上一次遍历的 node
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if ((cur.children.size() == 0) // 叶子节点
                    || (pre != null && cur.children.contains(pre)) // 此时 pre 一定是 cur 的最右边节点，这个是栈的顺序保证的
            ) {
                // 加入结果集
                res.add(cur.val);
                stack.pop();
                // 更新 pre 指针
                pre = cur;
            } else {
                // 继续压栈，注意压栈是从右往左
                List<Node> nodeList = cur.children;
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    stack.push(nodeList.get(i));
                }
            }
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
