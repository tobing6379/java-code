package top.tobing.jz_27;

import top.tobing.TreeNode;

/**
 * @author tobing
 * @date 2021/8/29 11:11
 * @description
 */
public class Solution {
    /**
     * 简单递归法
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTree = mirrorTree(root.left);
        TreeNode rightTree = mirrorTree(root.right);
        root.left = rightTree;
        root.right = leftTree;

        return root;
    }
}
