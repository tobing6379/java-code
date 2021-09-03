package top.tobing.jz_07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tobing
 * @Date 2021/8/4 11:13
 * @Description 剑指 Offer 07. 重建二叉树
 */
public class Solution {

    /**
     * 辅助Map
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 异常情况
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 保存二叉树节点与中序遍历序列位置的映射【题目保证了节点唯一性】
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        // buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    /**
     * 二叉树前序遍历序列的特性：
     * ——------------------
     * |根节点|左子树|右子树|
     * --------------------
     * 二叉树中序遍历序列特性为：
     * ——------------------
     * |左子树|根节点|右子树|
     * --------------------
     * 1、在重建二叉树的时，先根据前序遍历的最左边节点，确定根节点；
     * 2、再到中序遍历中寻找根节点的下标，左边为左子树，右边为右子树；
     * 3、通过下标可以知道左/右子树的节点个数，再到前序遍历中划分左右子树的范围
     *
     * @param preOrder    前序遍历序列
     * @param preStartIdx 前序遍历序列开始下标
     * @param preEndIdx   前序遍历序列结束下标
     * @param inOrder     后序遍历序列
     * @param inStartIdx  后序遍历序列开始下标
     * @param inEndIdx    后序遍历序列结束下标
     * @return 构建好的二叉树
     */
    private TreeNode buildTree(int[] preOrder,
                               int preStartIdx,
                               int preEndIdx,
                               int[] inOrder,
                               int inStartIdx,
                               int inEndIdx,
                               Map<Integer, Integer> map) {
        // 仅剩一个元素，直接创建节点并返回
        if (preStartIdx == preEndIdx) {
            return new TreeNode(preOrder[preStartIdx]);
        }

        // 获取根节点，创建创建节点
        TreeNode cur = new TreeNode(preOrder[preStartIdx]);
        // 计算根节点在中序遍历的位置
        Integer mid = map.get(preOrder[preStartIdx]);
        int leftChildrenLen = mid - inStartIdx;
        int rightChildrenLen = inEndIdx - mid;
        // 重新计算左子树在先序序列的范围
        int preLeftStartIdx = preStartIdx + 1;
        int preLeftEndIdx = preStartIdx + leftChildrenLen;
        int inLeftStartIdx = inStartIdx;
        int inLeftEndIdx = mid - 1;
        if (leftChildrenLen > 0) {
            cur.left = buildTree(preOrder, preLeftStartIdx, preLeftEndIdx, inOrder, inLeftStartIdx, inLeftEndIdx, map);
        }
        // 重新计算左子树在先序序列的范围
        int preRightStartIdx = preLeftEndIdx + 1;
        int preRightEndIdx = preEndIdx;
        int inRightStartIdx = mid + 1;
        int inRightEndIdx = inEndIdx;
        if (rightChildrenLen > 0) {
            cur.right = buildTree(preOrder, preRightStartIdx, preRightEndIdx, inOrder, inRightStartIdx, inRightEndIdx, map);
        }

        return cur;
    }

    private TreeNode build(int[] preOrder,
                           int preStartIdx,
                           int preEndIdx,
                           int[] inOrder,
                           int inStartIdx,
                           int inEndIdx,
                           Map<Integer, Integer> inorderMap) {
        if (preStartIdx == preEndIdx) {
            return new TreeNode(preOrder[preStartIdx]);
        }

        Integer rootVal = preOrder[preStartIdx];
        TreeNode curNode = new TreeNode(rootVal);


        /**
         * 【先序遍历序列】
         * preStartIdx                                    preEndIdx
         * ——------------------——------------------——--------------
         * |      根节点      |      左子树      |      右子树      |
         * ——------------------——------------------——--------------
         * 【中序遍历序列】
         * inStartIdx             inOrderMid               inEndIdx
         * ——------------------——------------------——--------------
         * |      左子树      |      根节点      |      右子树      |
         * ——------------------——------------------——--------------
         * 左子树节点个数：inOrderMid - inStatIdx;
         * 右子树节点个数：inEndIdx - inOrderMid;
         * 事实上只需要知道左子树节点个数即可
         */

        Integer inOrderMid = inorderMap.get(rootVal);
        int leftLen = inOrderMid - inStartIdx;
        int rightLen = inEndIdx - inOrderMid;
        if (leftLen != 0) {
            TreeNode leftTree = build(preOrder,
                    preStartIdx + 1,
                    preStartIdx + leftLen,
                    inOrder,
                    inStartIdx,
                    inOrderMid - 1,
                    inorderMap);
            curNode.left = leftTree;
        }
        if (rightLen != 0) {
            TreeNode rightTree = build(preOrder,
                    preStartIdx + leftLen + 1,
                    preEndIdx,
                    inOrder,
                    inOrderMid + 1,
                    inEndIdx,
                    inorderMap);
            curNode.right = rightTree;
        }

        return curNode;
    }


    public static void main(String[] args) {
        new Solution().buildTree(new int[]{1, 2}, new int[]{2, 1});
    }
}
