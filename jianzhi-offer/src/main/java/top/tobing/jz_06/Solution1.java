package top.tobing.jz_06;

import java.util.Arrays;

/**
 * @Author tobing
 * @Date 2021/8/2 12:17
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * 迭代法
 */
public class Solution1 {

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int size = 0;
        // 统计元素个数
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        // 根据元素个数创建数组
        int[] res = new int[size];
        // 第二次遍历，反序往数组添加元素
        cur = head;
        while (cur != null) {
            res[size - 1] = cur.val;
            cur = cur.next;
            size--;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode temp = new ListNode(1);
        ListNode head = temp;
        for (int i = 0; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        int[] ints = new Solution1().reversePrint(head.next);
        System.out.println(Arrays.toString(ints));
    }
}

