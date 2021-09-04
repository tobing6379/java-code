package top.tobing.jz_39;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/4 11:12
 * @description 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Solution1 {
    /**
     * 【摩尔多数投票法】
     * 使用场景：在集合中寻找可能存在的多数元素，这一元素在输入的序列重复出现并占到了序列元素的一半以上；
     * 算法原理：如果集合中元素超过一半，如果该元素与它不相同的元素抵消则最终剩下的元素肯定是多数元素；
     * 例外情况：假设集合中没有多数元素，可以在执行上述代码之后，统计多数元素是否的数量是否大于length/2；
     * 算法执行过程：
     * <p>
     * 【参考文献】
     * 论文MJRTY A Fast Majority Vote Algorithm：https://www.cs.ou.edu/~rlpage/dmtools/mjrty.pdf
     * 算法演示网站：https://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
     * 维基百科：https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int candidate = 0;
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前vote为0，选取一个选举人
            if (vote == 0) {
                candidate = nums[i];
                vote = 1;
                continue;
            }
            // 当前vote不为0，判断选举人与当前元素的关系
            if (nums[i] == candidate) {
                // 当前人员与candidate相同，直接累积
                vote++;
            } else {
                // 当前人员能与candidate不同，抵消
                vote--;
            }
        }
        // 由于题目提出：给定的数组总是存在多数元素。因此可以最终结果不需要遍历
        return candidate;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.majorityElement(nums));

    }
}
