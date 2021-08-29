package top.tobing.jz_28;

import top.tobing.TreeNode;

/**
 * @author tobing
 * @date 2021/8/29 11:14
 * @description
 */
public class Solution {


    /**
     * 辅助函数法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        } else if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.val != tree2.val) {
            return false;
        }

        return helper(tree1.left, tree2.right) && helper(tree1.right, tree2.left);
    }
}
