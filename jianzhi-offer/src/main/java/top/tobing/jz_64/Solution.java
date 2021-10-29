package top.tobing.jz_64;

/**
 * @author tobing
 * @date 2021/9/24 0:17
 * @description 剑指 Offer 64. 求1+2+…+n
 */
public class Solution {

    /**
     * 利用位运算符的短路
     */
    public int sumNums(int n) {
        boolean flag = n > 1
                && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(9));
    }
}
