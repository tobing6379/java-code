package top.tobing.jz_15;

/**
 * @author tobing
 * @date 2021/8/8 12:32
 * @description 剑指 Offer 15. 二进制中1的个数
 */
public class Solution2 {
    /**
     * JavaAPI解法
     * Java对于位的运算有更加精妙的设计，具体不展开说，等后面有精力再整了。
     * bitCount实现直接使用IDEA进入查看即可{@link Integer#bitCount(int)}
     * 详情看博客：https://segmentfault.com/a/1190000015763941
     * 更多的位运算相关题目可以关注下面的题解
     * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/gong-shui-san-xie-yi-ti-si-jie-wei-shu-j-g9w6/
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().hammingWeight(-10101));
    }
}
