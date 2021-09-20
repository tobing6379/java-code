package top.tobing.jz_54;

import top.tobing.TreeNode;

/**
 * @author tobing
 * @date 2021/9/20 13:06
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Solution {

    private int res;
    private int k;

    /**
     * 中序遍历
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (k-- == 0) {
            res = node.val;
        }
        inOrder(node.right);
    }
}
