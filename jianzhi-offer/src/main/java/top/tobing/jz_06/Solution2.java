package top.tobing.jz_06;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author tobing
 * @Date 2021/8/2 12:17
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * 辅助栈法
 */
public class Solution2 {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
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
        int[] ints = new Solution2().reversePrint(head.next);
        System.out.println(Arrays.toString(ints));
    }
}

