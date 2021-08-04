package top.tobing.jz_11;

/**
 * @Author tobing
 * @Date 2021/8/4 18:30
 * @Description 剑指 Offer 11. 旋转数组的最小数字
 */
public class Solution1 {

    /**
     * 二分法
     * [3,4,5,1,2]、[2,2,2,0,1]、[2,2,0,1,2]
     * 另最小下标为startIdx，最大下标为endIdx，则中间元素的小标为midIdx
     * 如果 numbers[midIdx]< numbers[startIdx]，则表示转折点一定在 [startIdx, midIdx](左边)
     * 如果 numbers[midIdx]> numbers[startIdx]，则表示转折点一定在 [midIdx+1,endIdx](右边)
     * 如果 numbers[midIdx]= numbers[startIdx]，无法判断转折点在哪个排序数组中，执行startIdx++
     */
    public int minArray(int[] numbers) {
        int startIdx = 0;
        int endIdx = numbers.length - 1;
        while (startIdx < endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if (numbers[midIdx] > numbers[endIdx]) {
                startIdx = midIdx + 1;
            } else if (numbers[midIdx] < numbers[endIdx]) {
                endIdx = midIdx;
            } else {
                int x = startIdx;
                for (int k = startIdx + 1; k < endIdx; k++) {
                    if (numbers[k] < numbers[x]) {
                        x = k;
                    }
                }
                return numbers[x];
            }
        }
        return numbers[startIdx];
    }

}
