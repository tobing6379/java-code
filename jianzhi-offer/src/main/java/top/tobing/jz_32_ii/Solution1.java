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
public class Solution1 {

    private List<List<Integer>> res;


    /**
     * 递归法
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        levelOrder(root, 0);
        return res;
    }

    private void levelOrder(TreeNode node, int level) {
        if (node == null) {
            return;
        }


        if (level >= res.size()) {
            List<Integer> levelElements = new ArrayList<>();
            res.add(levelElements);
            levelElements.add(node.val);
        } else {
            List<Integer> levelElements = res.get(level);
            levelElements.add(node.val);
        }
        levelOrder(node.left, level + 1);
        levelOrder(node.right, level + 1);
    }

}
