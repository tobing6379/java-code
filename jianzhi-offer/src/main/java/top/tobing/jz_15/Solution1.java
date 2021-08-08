package top.tobing.jz_15;

/**
 * @author tobing
 * @date 2021/8/8 12:32
 * @description 剑指 Offer 15. 二进制中1的个数
 */
public class Solution1 {
    /**
     * 位运算法
     * n&1=0，最后一位为0
     * n&1=1，最后一位为1
     * 【Java位运算】
     * 位运算允许我们操作一个整形数字中的单个二进制位。
     * 位运算符会对两个整数对应的位执行布尔代数，从而让产生结果。
     * 位运算来源于C语言的底层操作。在C语言中需要直接操作硬件，频繁设置硬件寄存器内的二进制位
     * Java设计的初衷是电视机顶盒嵌入式开发，因此这种底层操作仍然被保留了下来。
     * 【位移运算】
     * 左移位运算符 << 能将其左边的运算对象向左移动右侧指定的位数（在低位补 0）
     * 右移位运算符 >> 则相反。右移位运算符有 “正”、 “负” 值：
     * 若值为正，则在高位插入 0；若值为负，则在高位插入 1。
     * Java添加了一种「不分正负」的右位移运算(>>>)，使用零扩展
     * 无论正负，都在高位插入 0。这一运算符是 C/C++ 没有的。
     * 如果移动 char、 byte 或 short，则会在移动发生之前将其提升为 int，结果为 int。
     * 仅使用右值（rvalue）的 5 个低阶位。这可以防止我们移动超过 int 范围的位数。
     * 若对一个 long 值进行处理，最后得到的结果也是 long。
     */
    public int hammingWeight(int n) {
        int res = 0;
        /// 下面代码由while(n!=0)改进
        // for (int i = 0; i < 32; i++) {
        //     res += n & 1;
        //     n >>>= 1;
        // }
        // 上面代码中每次都要执行32次
        // 然而事实上，当n==0的时候我们就不需要再进行位移操作了，这样可以减少一些不必要的操作
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().hammingWeight(-10101));
    }
}
