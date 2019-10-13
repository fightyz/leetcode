package com.joeyang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class Problem100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 用递归算法比较好是因为两棵树的遍历可以同时进行，如果用迭代算法，则中间判断的退出条件会很多。
     * 其实这样的迭代算法本质上也是先序遍历。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为空的话，显然相同
        if (p == null && q == null) return true;
        // 一个为空，一个非空，显然不同
        if (p == null || q == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (p.val != q.val) return false;

        // p, q 该比的都比完了
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
