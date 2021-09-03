package top.tobing.leetcode.lc_765;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/1 23:58
 * @description 765. 情侣牵手
 * 解法1：并查集
 */
public class Solution {


    private int[] ids;


    /**
     * 并查集
     * <p>
     * 对于一个需要交换的集合中(元素对数为1对)，最少仅需要交换i-1次。如{ (2,4)、(3,6)、(5,7) }，仅需要交换2次
     * 最少交换次数 = sum(每个需要交换元素集合的交换次数) = 需要交换元素总对数-需要交换集合个数 = (总元素对数-不需要交换对数)-(总集合个数-不需要交换集合个数)
     * 由于，不需要交换集合个数=不需要交换对数
     * 因此，最少交换次数=总元素对数-总集合个数
     */
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) {
            return 0;
        }

        // 初始化并查集结构
        ids = new int[row.length >>> 1];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }

        // 记录不需要交换的元素个数，将其合并到一个集合
        for (int i = 0; i < row.length; i += 2) {
            int a = row[i];
            int b = row[i + 1];
            if (!isCouples(a, b)) {
                a = a >>> 1;
                b = b >>> 1;
                union(a, b);
            }
        }


        Set<Integer> set = new HashSet<>();
        for (int id : ids) {
            set.add(id);
        }

        int res = ids.length - set.size();

        return res;
    }


    /**
     * 判断两个是否为情侣
     * 如0,1和2,3整数除于2，其结果相等
     */
    private boolean isCouples(int a, int b) {
        // equals with a/2 == b/2;
        return a >>> 1 == b >>> 1;
    }

    /**
     * 合并
     */
    private void union(int p, int q) {
        int pId = ids[p];
        int qId = ids[q];

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) {
                ids[i] = qId;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {0, 2, 1, 3};
        System.out.println(solution.minSwapsCouples(test1));
    }

}
