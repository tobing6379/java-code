package top.tobing.jz_32_iii;

import top.tobing.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/8/31 11:06
 * @description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Solution1 {

    /**
     * 数组反序+奇偶分离
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
            // 偶数层不反转，奇数反转
            if (res.size() % 2 != 0) {
                Collections.reverse(level);
            }
            res.add(level);
        }
        return res;
    }
}
