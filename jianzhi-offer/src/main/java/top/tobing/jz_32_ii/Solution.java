package top.tobing.jz_32_ii;

import top.tobing.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tobing
 * @date 2021/8/30 11:23
 * @description 剑指 Offer 32 - II. 从上到下打印二叉树
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 记录每层的大小
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            // 每次只操作当前层的元素
            for (int i = 0; i < size; i++) {
                TreeNode removeNode = queue.remove();
                level.add(removeNode.val);
                if (removeNode.left != null) {
                    queue.add(removeNode.left);
                }
                if (removeNode.right != null) {
                    queue.add(removeNode.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
