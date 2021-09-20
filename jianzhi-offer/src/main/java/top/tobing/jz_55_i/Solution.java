package top.tobing.jz_55_i;

import top.tobing.TreeNode;

/**
 * @author tobing
 * @date 2021/9/20 13:28
 * @description 剑指 Offer 55 - I. 二叉树的深度
 */
public class Solution {

    /**
     * 简单递归法
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
