package top.tobing.jz_37;

import top.tobing.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author tobing
 * @date 2021/9/2 11:13
 * @description 剑指 Offer 37. 序列化二叉树
 */
public class Solution {

}

/**
 * 层序遍历
 */
class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        // 队列辅助实现层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        // 去除[]，并根据「,」分割属性
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(vals[i])) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(vals[i])) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
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

        String serialize = codec.serialize(node5_root);
        TreeNode deserialize = codec.deserialize(serialize);
        String res = codec.serialize(deserialize);
        System.out.println(res);
    }
}