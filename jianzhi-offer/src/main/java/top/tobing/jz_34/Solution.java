package top.tobing.jz_34;

import top.tobing.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tobing
 * @date 2021/9/1 11:35
 * @description 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Solution {

    /**
     * 结果
     */
    private List<List<Integer>> res = new ArrayList<>();
    /**
     * 使用栈保存遍历的路径
     */
    private Stack<Integer> path;

    /**
     * 辅助栈+回溯
     * 利用辅助栈记录遍历的路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        path = new Stack<>();
        rec(root, target, 0);
        return res;
    }

    private void rec(TreeNode root, int target, int curVal) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            if (curVal + root.val == target) {
                path.push(root.val);
                List<Integer> level = new ArrayList<>(path);
                res.add(level);
                path.pop();
            }
        }
        // 非叶子节点
        path.push(root.val);
        // 递归左子树
        if (root.left != null) {
            rec(root.left, target, curVal + root.val);
        }
        // 递归右子树
        if (root.right != null) {
            rec(root.right, target, curVal + root.val);
        }
        path.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //                5
        //               / \
        //              4   8
        //             /   / \
        //            11  13  4
        //           /  \    / \
        //          7    2  5   1
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5_root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        node5_root.left = node41;
        node5_root.right = node8;
        node41.left = node11;
        node8.left = node13;
        node8.right = node42;
        node11.left = node7;
        node11.right = node2;
        node42.left = node5;
        node41.right = node1;

        List<List<Integer>> res = solution.pathSum(node5_root, 22);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
