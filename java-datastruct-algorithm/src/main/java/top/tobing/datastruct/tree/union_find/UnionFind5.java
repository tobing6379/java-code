package top.tobing.datastruct.tree.union_find;

/**
 * @author tobing
 * @date 2021/8/31 15:08
 * @description 并查集实现2优化-QuickUnion路径压缩优化
 */
public class UnionFind5 implements UF {

    /**
     * QuickUnion使用数组构建一棵指向父节点的树
     * parent[i]代表第一个元素指向的父节点
     */
    private int[] parent;

    /**
     * rank[i]代表以i为根的集合所代表的树的层数
     */
    private int[] rank;


    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];
        // 初始化，将每一个id[i]指向自己，没有合并元素
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 寻找p对应的集合编号
     * 时间复杂度O(h)，h为树的高度
     * 查找p对应集合编号时，不对循环的过程中不断进行路径压缩
     */
    private int find(int p) {
        // p的合法性判断
        if (p < 0 || p > parent.length - 1) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        // 不断查询自己的父节点，直到到达根节点
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素p和元素q是否属于一个集合
     * 时间复杂度O(h)，h为树的高度
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将元素p与元素q所在集合机型合并
     * 时间复杂度O(h)
     */
    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        // p和q属于同一集合，无需合并
        if (pRoot == qRoot) {
            return;
        }

        // 合并:根据两个元素所在树的层数不同判断合并的方向
        // 将层数少的集合合并到层数多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            // p合并到q
            parent[pRoot] = parent[qRoot];
        } else if (rank[pRoot] > rank[qRoot]) {
            // q合并到p
            parent[qRoot] = parent[pRoot];
        } else {
            // q合并到p，维护rank
            parent[qRoot] = parent[pRoot];
            rank[pRoot]++;
        }
    }

    /**
     * 统计并查集内的区间个数
     */
    public int count() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
}
