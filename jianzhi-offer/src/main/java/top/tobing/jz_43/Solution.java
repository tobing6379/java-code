package top.tobing.jz_43;

/**
 * @author tobing
 * @date 2021/9/6 20:40
 * @description 剑指 Offer 43. 1～n 整数中 1 出现的次数
 */
public class Solution {


    /**
     * --------------
     * |high|cur|low|
     * --------------
     * cur=0;  times=high×digit;
     * cur=1;  times=high×digit+low+1;
     * cur=2~9;times=(high+1)×digit
     */
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int temp = 0;
        for (int i = 10; i <= 120; i++) {
            if (i % 10 == 1) {
                temp++;
            }
        }
        System.out.println(temp);
    }
}
