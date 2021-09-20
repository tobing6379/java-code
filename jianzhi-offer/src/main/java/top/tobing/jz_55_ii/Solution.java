package top.tobing.jz_55_ii;

import top.tobing.TreeNode;

/**
 * @author tobing
 * @date 2021/9/20 13:48
 * @description 剑指 Offer 55 - II. 平衡二叉树
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = maxDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
