package top.tobing.jz_11;

/**
 * @Author tobing
 * @Date 2021/8/4 18:30
 * @Description 剑指 Offer 11. 旋转数组的最小数字
 */
public class Solution {

    /**
     * 普通遍历
     * 引用数组中元素是递增的，结合旋转特征，第一个「元素值比前面元素小」的元素就是转折点，也是最小值
     * 如果不存在比前面元素小的，说明不存在翻转，直接返回第一个就是最小值
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
