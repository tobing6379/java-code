package top.tobing.jz_03;

/**
 * @Author tobing
 * @Date 2021/8/3 9:02
 * @Description 剑指 Offer 03. 数组中重复的数字
 */
public class Solution1 {

    /**
     * 原地交换
     * 利用「在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内」条件，考虑将每个元素，移动到对于的下标
     * 即在从左到右遍历nums时，不断将 nums[i] 的元素移动到 nums[nums[i]] 的位置，直到 nums[i]=i，可以表示当前元素已经归位，
     * 在挪动的过程中，如果存在 nums[nums[i]] == nums[i]，表明元素已经重复，直接返回即可
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            // 注意下面的 nums[tmp] 不能改为 nums[nums[i]]，因此此时nums[i]的值已经和刚刚开始的发生了改变
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        // 3, 4, 2, 0, 0, 1
        // 2, 3, 1, 0, 2, 5, 3
        int res = new Solution1().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(res);
    }
}
