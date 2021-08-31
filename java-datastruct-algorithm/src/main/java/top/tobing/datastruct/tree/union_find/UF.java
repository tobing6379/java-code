package top.tobing.datastruct.tree.union_find;

/**
 * @author tobing
 * @date 2021/8/31 15:03
 * @description 并查集接口
 */
public interface UF {

    /**
     * 获取并查集元素个数
     */
    int getSize();

    /**
     * 判断集合中p和q是否连接
     */
    boolean isConnected(int p, int q);

    /**
     * 将集合中p和q所在子集进行合并
     */
    void unionElement(int p, int q);
}
