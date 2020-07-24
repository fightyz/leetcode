package com.joeyang;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            int levelNum = queueP.size();
            for (int i = 0; i < levelNum; i++) {
                if (queueP.peek().left != null && queueQ.peek().left != null) {
                    queueP.offer(queueP.peek().left);
                    queueQ.offer(queueQ.peek().left);
                } else if(queueP.peek().left == null && queueQ.peek().left == null) {
                } else {
                    return false;
                }
                if (queueP.peek().right != null && queueQ.peek().right != null) {
                    queueP.offer(queueP.peek().right);
                    queueQ.offer(queueQ.peek().right);
                } else if (queueQ.peek().right == null && queueQ.peek().right == null){
                } else {
                    return false;
                }
                if (queueP.poll().val != queueQ.poll().val) {
                    return false;
                }
            }
        }
        return true;
    }
}
