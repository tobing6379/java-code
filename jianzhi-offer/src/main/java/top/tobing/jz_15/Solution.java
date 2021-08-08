package top.tobing.jz_15;

/**
 * @author tobing
 * @date 2021/8/8 12:32
 * @description 剑指 Offer 15. 二进制中1的个数
 */
public class Solution {
    /**
     * 简单位移法
     * 编译器使用「二进制补码」记法来表示有符号整数
     * ⑴如果补码的符号位为“0”，表示是一个正数；
     * ⑵如果补码的符号位为“1”，表示是一个负数；
     * 负数对2求余，其结果是0或-1
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (n % 2 != 0) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
    }
}
