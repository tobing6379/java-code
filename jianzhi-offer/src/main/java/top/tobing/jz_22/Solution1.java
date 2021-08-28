package top.tobing.jz_22;

import top.tobing.ListNode;

/**
 * @author tobing
 * @date 2021/8/28 10:32
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Solution1 {


    /**
     * 指针偏移
     * 利用偏移的k个元素的指针cur和curOffset
     * 同时移动cur和curOffset，当curOffset的next为NULL，则cur为到时第k个元素
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // 将curOffset与head偏移k-1个元素
        ListNode curOffset = head;
        while (k > 0) {
            k--;
            curOffset = curOffset.next;
        }
        // curOffset同时移动
        while (curOffset != null) {
            curOffset = curOffset.next;
            head = head.next;
        }
        // 当curOffset为NULL，head为到时第k个元素
        return head;
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
        //                     ↑          ↑
        //                     head      curOffset
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.generateList(10);
        System.out.println(ListNode.printListNode(listNode));
        ListNode res = new Solution1().getKthFromEnd(listNode, 2);
        System.out.println(ListNode.printListNode(res));
    }
}
