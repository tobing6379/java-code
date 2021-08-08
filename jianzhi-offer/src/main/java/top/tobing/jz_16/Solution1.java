package top.tobing.jz_16;

/**
 * @author tobing
 * @date 2021/8/8 13:31
 * @description 剑指 Offer 16. 数值的整数次方
 */
public class Solution1 {

    /**
     * 快速幂法
     * 我还没用足够理解，想要弄清楚，可以看以下的题解
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-dan-li-jie-kuai-su-mi-by-ollieq-rl74/
     * <p>
     * 假设需要算 x^11
     * --------------------------------------------
     * 首先先理解temp*=temp操作，后面用到。
     * 假设temp=x，res=1，则每次执行temp*=temp操作相关
     * 1     temp=x     ==> temp            =x^1=x^(2^0)   【√】res*=temp=x^1
     * 1     temp*=temp ==> temp            =x^2=x^(2^1)   【√】res*=temp=x^1*x^2
     * 0     temp*=temp ==> temp=x^2*x^2    =x^4=x^(2^2)
     * 1     tmep*=temp ==> temp=x^4*x^4    =x^8=x^(2^3)   【√】res*=temp=x^1*x^2*x^8
     * 0     temp*=temp ==> temp=x^8*x^8    =x^16=x^(2^4)
     * x^11可以转化为求x^(1+2+8)，即x^1*x^2*x^8，参照上面打钩的地方，只需要在打钩的地方执行一次运算即可。
     * 那么怎么确定哪里是需要打钩的呢？
     * 可发现，其实只有在11的二进制为1的地方，才需要打上钩。
     */
    public double myPow(double x, int n) {
        // 1的n次幂等于1，任何数的0次幂等于1
        if (n == 0 || 1.0 == x) {
            return 1;
        }
        // 0的其他次幂等于0
        if (x == 0) {
            return 0;
        }
        double res = 1.0;
        long b = n;
        // 处理n为负数的情况
        // 将其转换为倒数即可
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        // 对于n，遍历其二进制位
        while (b != 0) {
            if ((n & 1) == 1) {
                // 如果为二进制位上为1，则需要打钩
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().myPow(2, 4));
    }
}
