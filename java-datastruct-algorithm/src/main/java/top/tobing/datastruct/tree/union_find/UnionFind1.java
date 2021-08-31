package top.tobing.datastruct.tree.union_find;

/**
 * @author tobing
 * @date 2021/8/31 15:08
 * @description 并查集实现1-QuickFind
 */
public class UnionFind1 implements UF {

    /**
     * QuickUnion的实现本质就是一个数组
     */
    private int[] id;


    public UnionFind1(int size) {
        id = new int[size];
        // 初始化，将每一个id[i]指向自己，没有合并元素
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 寻找p对应的集合编号
     * 时间复杂度O(1)
     */
    private int find(int p) {
        // p的合法性判断
        if (p < 0 || p > id.length - 1) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    /**
     * 查看元素p和元素q是否属于一个集合
     * 时间复杂度O(1)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将元素p与元素q所在集合机型合并
     * 时间复杂度O(n)
     */
    @Override
    public void unionElement(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        // p和q属于同一集合，无需合并
        if (pID == qID) {
            return;
        }

        // 合并：遍历所有元素，将两个元素所属集合编号合并
        for (int i = 0; i < getSize(); i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
