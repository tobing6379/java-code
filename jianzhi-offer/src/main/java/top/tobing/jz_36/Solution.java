package top.tobing.jz_36;


import java.util.ArrayList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/9/1 14:04
 * @description
 */
public class Solution {

    private Node prev;
    private Node head;


    /**
     * 中序遍历法
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        inorder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }
        root.left = prev;
        prev = root;
        inorder(root.right);
    }
}
