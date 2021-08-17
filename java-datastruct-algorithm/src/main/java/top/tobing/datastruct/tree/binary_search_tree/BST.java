package top.tobing.datastruct.tree.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author tobing
 * @Date 2021/8/3 11:19
 * @Description 二分搜索树
 * BST的实现，主要包含以下功能
 * 插入 {@link BST#add(java.lang.Comparable)}
 * 包含 {@link BST#contains(Comparable)}
 * 前序遍历【递归】{@link BST#preOrder()}
 * 中序遍历【递归】{@link BST#inOrder()}
 * 后序遍历【递归】{@link BST#postOrder()}
 * 前序遍历【非递归】{@link BST#preOrderNR()}
 * 中序遍历【非递归】{@link BST#inOrderNR()} 未实现
 * 后序遍历【非递归】{@link BST#postOrderNR()} 未实现
 * 层序遍历 {@link BST#levelOrder()}
 * 获取最大值 {@link BST#maximum()}
 * 获取最小值 {@link BST#minimum()}
 * 删除最大值 {@link BST#removeMax()}
 * 删除最小值 {@link BST#removeMin()}
 * 删除任意元素 {@link BST#remove(Comparable)}
 */
public class BST<E extends Comparable> {

    /**
     * 二叉树节点
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 二叉搜索树根节点
     */
    private Node root;
    /**
     * 二叉树搜索树节点个数
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 插入【递归】
     * 向以node为根的二分搜索树中插入元素e
     * 返回插入新节点后的二分搜索树的根
     */
    public Node add(Node node, E e) {
        if (node == null) {
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            // e < node.e
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // e > node.e
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看二叉树中舒服存在元素 e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 包含【递归】
     * 判断以node为根的二叉树是否包含元素e
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            // e < node.e
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // e > node.e
            return contains(node.right, e);
        } else {
            // e = node.e
            return true;
        }
    }

    ///////////////////////////////遍历////////////////////////////////

    /**
     * 二叉树前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二叉树【递归】
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        // 访问根节点
        System.out.println(node.e);
        //访问左节点
        preOrder(node.left);
        // 访问右节点
        preOrder(node.right);
    }

    /**
     * 二叉树中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二叉树【递归】
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        // 访问左子树
        inOrder(node.left);
        // 访问根节点
        System.out.println(node.e);
        // 访问右子树
        inOrder(node.right);
    }

    /**
     * 二叉树后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二叉树【递归】
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        // 访问左子树
        postOrder(node.left);
        // 访问右子树
        postOrder(node.right);
        // 访问根节点
        System.out.println(node.e);
    }

    /**
     * 二叉树前序遍历【非递归】
     */
    public void preOrderNR() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 注意左右子节点的压栈顺序
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉树后序遍历【非递归】
     * TODO tobing 2021年8月3日
     */
    public void postOrderNR() {
    }

    /**
     * 二叉树中序遍历【非递归】
     * TODO tobing 2021年8月3日
     */
    public void inOrderNR() {
    }

    /**
     * 二叉树层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    ///////////////////////////////遍历////////////////////////////////

    /**
     * 寻找二分搜索树的最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root).e;
    }

    /**
     * 返回以node为根的二叉搜索树的最小值所在节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二叉搜索树的最大值所在节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点【递归】
     * 返回删除后节点新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;

        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     */
    private void generateString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(6);
        bst.add(4);
        bst.add(3);
        bst.add(7);
        bst.add(8);
        bst.add(9);
        System.out.println(bst);

        System.out.println("========================前序遍历========================");
        bst.preOrder();
        System.out.println("========================中序遍历========================");
        bst.inOrder();
        System.out.println("========================后序遍历========================");
        bst.postOrder();
        System.out.println("========================前序遍历【非递归】========================");
        bst.preOrderNR();
        System.out.println("========================后序遍历【非递归】========================");

    }
}
