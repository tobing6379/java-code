package top.tobing.datastruct.tree.red_black_tree;

import java.util.Objects;

/**
 * @author tobing
 * @date 2021/10/1 18:37
 * @description 红黑树-左倾实现
 * 【红黑树的性质】
 * 1）每个节点或者是红色，或者是黑色；
 * 2）根节点是黑色的；
 * 3）每个叶子节点（包含空节点）是黑色的；
 * 4）如果一个节点是红色的，那么其孩子节点是黑色的；
 * 5）任意一个节点到叶子节点的，经过的黑色节点是一样的；
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    /**
     * 红黑树节点
     */
    private class Node {
        // 键
        public K key;
        // 值
        public V value;
        // 节点颜色：RED or BLACK
        public boolean color;
        // 左右孩子节点
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            color = RED;
        }
    }

    /**
     * 红黑树根节点
     */
    private Node root;
    /**
     * 红黑树大小
     */
    private int size;

    /**
     * 构造器
     */
    public RBTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 判断节点node的颜色
     */
    private boolean isRed(Node node) {
        if (node == null) {
            // 红黑树性质：每个叶子节点是黑色的（null）
            return BLACK;
        }
        return node.color;
    }

    /**
     * 向红黑树中添加元素
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 先以node为根的红黑树添加元素（key,value），递归算法
     * 返回插入新节点之后的红黑树的根
     */
    private Node add(Node node, K key, V value) {
        // 红黑树为空 或 到达叶子节点创建一个新节点
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) { // key < node.key
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) { // key > node.key
            node.right = add(node.right, key, value);
        } else { // key == node.key
            // 仅更新value
            node.value = value;
        }

        return node;
    }

    /**
     * 返回以node为根的红黑树中，key所在节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (Objects.equals(node.key, key)) { // key == node.key
            return node;
        } else if (key.compareTo(node.key) < 0) {  // key < node.key
            return getNode(node.left, key);
        } else { // key > node.key
            return getNode(node.right, key);
        }
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


}
