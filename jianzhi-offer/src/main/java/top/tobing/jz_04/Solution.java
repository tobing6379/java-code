package top.tobing.jz_04;

/**
 * @Author tobing
 * @Date 2021/8/2 8:57
 * @Description 剑指 Offer 04. 二维数组中的查找
 */
public class Solution {
    /**
     * 暴力解法
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length;
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] temp = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 3},
        };
        boolean res = new Solution().findNumberIn2DArray(temp, 5);
        System.out.println(res);
    }
}
