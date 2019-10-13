package com.joeyang;

public class ValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 当进入函数是由左节点进入时，max 代表的是父节点，min 一定为 null。表示该节点值上限为父节点值，下限无线小
     * 当进入函数是由有节点进入时，max 已定位 null，min 代表的是父节点。表示该节点值上限为无限大，下限为父节点值
     * @param root
     * @param min
     * @param max
     * @return
     */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.right, root, max);
    }
}
