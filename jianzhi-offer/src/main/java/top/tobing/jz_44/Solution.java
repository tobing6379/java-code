package top.tobing.jz_44;

/**
 * @author tobing
 * @date 2021/9/7 17:00
 * @description 剑指 Offer 44. 数字序列中某一位的数字
 */
public class Solution {
    /**
     * 012345689101112131415
     * --------------------------------------------------
     * | 数字范围  | 位数  |   数位数量    |  n=n-count   |
     * -------------------------------------------------
     * |    1~9    |   1   |       9       |     n-9      |
     * |   10~99   |   2   |      180      |   n-9-180    |
     * |  100~999  |   3   |     2700      | n-9-180-2700 |
     * | start-end | digit | 9xstartxdigit | 直到n<=count |
     * -------------------------------------------------
     */
    public int findNthDigit(int n) {
        // 数位
        int digit = 1;
        // 开始的数值
        long start = 1;
        // 到start前面的数值
        long count = 9;
        // 计算第n位数在「k位数」上，如100为3位数，99为2位数
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 计算第n位数在「k位数」上的第m个数
        long num = start + (n - 1) / digit;
        // 返回第n位数在「k位数」上的第m个数的第j位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nthDigit = solution.findNthDigit(15);
    }
}
