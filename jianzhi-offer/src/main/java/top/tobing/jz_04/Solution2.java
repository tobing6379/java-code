package top.tobing.jz_04;

/**
 * @Author tobing
 * @Date 2021/8/2 8:57
 * @Description 剑指 Offer 04. 二维数组中的查找
 */
public class Solution2 {
    /**
     * 【行列消除法】
     * 从题目中规则可以知道，每行从左到右，每列从上到下，都是从小到大的
     * {1, 4, 7, 11, 15},
     * {2, 5, 8, 12, 19},
     * {3, 6, 9, 16, 22},
     * {10, 13, 14, 17, 24},
     * {18, 21, 23, 26, 30}
     * 对于最左下角的元素是最后一列的最小元素，如果target比它小，则target比该行的要小，该列可以消除【列消除】
     * {1, 4, 7, 11, 15},
     * {2, 5, 8, 12, 19},
     * {3, 6, 9, 16, 22},
     * {10, 13, 14, 17, 24}
     * 以此类推
     * {1, 4, 7, 11, 15},
     * {2, 5, 8, 12, 19},
     * {3, 6, 9, 16, 22}
     * 对于最左下角的元素也是第一行的最大元素，如果target比它大，则target比该列的要大，该行可以消除【行消除】
     * {7, 11, 15},
     * {8, 12, 19},
     * {9, 16, 22}
     * 【行消除】
     * {7, 11, 15}
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 特殊条件
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // matrix[i][j] 为最左下角元素
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

    // 测试
    public static void main(String[] args) {
        int[][] temp = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        boolean res = new Solution2().findNumberIn2DArray(temp, 30);
        System.out.println(res);
    }
}
