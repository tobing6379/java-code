package top.tobing.jz_63;

/**
 * @author tobing
 * @date 2021/9/23 23:25
 * @description 剑指 Offer 63. 股票的最大利润
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0;
        int preMinNumber = prices[0];
        for (int i = 1; i < prices.length; i++) {
            preMinNumber = Math.min(preMinNumber, prices[i]);
            res = Math.max(prices[i] - preMinNumber, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test1 = {7, 1, 5, 3, 6, 4};
        int[] test2 = {7, 6, 4, 3, 1};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(test1));
        System.out.println(solution.maxProfit(test2));

    }
}
