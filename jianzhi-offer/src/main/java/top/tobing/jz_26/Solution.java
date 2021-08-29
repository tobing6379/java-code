package top.tobing.jz_26;

import top.tobing.TreeNode;

/**
 * @author tobing
 * @date 2021/8/29 10:26
 * @description
 */
public class Solution {

    /**
     * 遍历递归法
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B)
                || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 判断B是否为A的同根子树
     */
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
