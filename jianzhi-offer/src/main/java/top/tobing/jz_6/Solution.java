package top.tobing.jz_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tobing
 * @Date 2021/8/2 12:17
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * 递归法
 */
public class Solution {

    private List<Integer> list;

    public int[] reversePrint(ListNode head) {
        // 例外情况
        if (head == null) {
            return new int[0];
        }
        // lazy-loading
        list = new ArrayList<>();
        // 递归遍历
        recursive(head);
        // 将List转换为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void recursive(ListNode head) {
        if (head == null) {
            return;
        }
        recursive(head.next);
        list.add(head.val);
    }

    public static void main(String[] args) {
        ListNode temp = new ListNode(1);
        ListNode head = temp;
        for (int i = 0; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        int[] ints = new Solution().reversePrint(head.next);
        System.out.println(Arrays.toString(ints));
    }
}

