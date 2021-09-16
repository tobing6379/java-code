package top.tobing.jz_46;

/**
 * @author tobing
 * @date 2021/9/15 11:16
 * @description 剑指 Offer 46. 把数字翻译成字符串
 */
public class Solution {
    private int res;

    public int translateNum(int num) {
        res = 0;
        if (num <= 0) {
            return res;
        }
        dfs(num);
        return res;
    }

    private void dfs(int num) {
        if (num >= 0 && num <= 9) {
            // 只有一位数，直接返回
            res++;
            return;
        } else if (num >= 10 && num <= 25) {
            // 合法的两位数
            res += 2;
            return;
        }
        // 将数据取数据后两位
        int temp = num % 100;
        if (temp >= 10 && temp <= 25) {
            // 存在两种分法
            dfs(num / 10);
            dfs(num / 100);
        } else { // temp ∈ 0~9 || temp ∈ 26~99
            // 只存在一种分法
            dfs(num / 10);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
