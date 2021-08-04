package top.tobing.jz_04;

/**
 * @Author tobing
 * @Date 2021/8/2 8:57
 * @Description 剑指 Offer 04. 二维数组中的查找
 */
public class Solution1 {
    /**
     * 二分法
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (binaryFind(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }


    // 二分法查找
    private boolean binaryFind(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // 防止溢出
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
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
        boolean res = new Solution1().findNumberIn2DArray(temp, 33);
        System.out.println(res);
    }
}
