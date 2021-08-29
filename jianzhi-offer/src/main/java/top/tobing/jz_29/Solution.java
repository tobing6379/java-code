package top.tobing.jz_29;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/29 11:20
 * @description
 */
public class Solution {


    /**
     * 模拟法
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int idx = 0;
        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;
        while (true) {
            // left->right 靠上
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            // top->bottom 靠右
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            // right->left 靠下
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                break;
            }
            // bottom->top 靠左
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[] ints = solution.spiralOrder(test);
        System.out.println(Arrays.toString(ints));
    }
}
