package top.tobing.jz_17;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/9 8:48
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Solution1 {

    char[] num;
    int[] ans;
    int count = 0, n;

    /**
     * 全排序，未理解
     */
    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return ans;
    }

    private void dfs(int n) {
        if (n == this.n) {
            String tmp = String.valueOf(num);
            int curNum = Integer.parseInt(tmp);
            if (curNum != 0) {
                ans[count++] = curNum;
            }
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }


    public static void main(String[] args) {
        int[] res = new Solution1().printNumbers(7);
        System.out.println(Arrays.toString(res));
    }
}
