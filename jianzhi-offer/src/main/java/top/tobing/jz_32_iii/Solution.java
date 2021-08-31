package top.tobing.jz_32_iii;

import top.tobing.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/8/31 11:06
 * @description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Solution {

    /**
     * 双向队列+奇偶分离
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 偶数层：从左往右遍历，先访问左孩子，再访问右孩子
            for (int i = linkedList.size(); i > 0; i--) {
                TreeNode node = linkedList.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
            res.add(level);

            // 当linkedList为空，提前退出
            if (linkedList.isEmpty()) {
                break;
            }

            // 奇数层：从右往左遍历，先访问右孩子，再访问左孩子
            level = new ArrayList<>();
            for (int i = linkedList.size(); i > 0; i--) {
                TreeNode node = linkedList.removeLast();
                level.add(node.val);
                if (node.right != null) {
                    linkedList.addFirst(node.right);
                }
                if (node.left != null) {
                    linkedList.addFirst(node.left);
                }
            }
            res.add(level);
        }
        return res;
    }
}
