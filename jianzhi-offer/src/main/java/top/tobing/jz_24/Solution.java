package top.tobing.jz_24;

import top.tobing.ListNode;

/**
 * @author tobing
 * @date 2021/8/28 11:15
 * @description 剑指 Offer 24. 反转链表
 */
public class Solution {
    /**
     * 递归法
     * 递归到底（head.next=null）时，开始反转，具体步骤为
     * ①head.next.next=head 当前节点的下一个节点指向当前节点
     * ②head.next = null 当前节点指向的元素置空
     * ③返回新的表头res
     */
    public ListNode reverseList(ListNode head) {
        // 链表为NULL或仅有一个节点的，无需执行反转，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.generateList(10);
        System.out.println(ListNode.printListNode(listNode));
        ListNode res = new Solution().reverseList(listNode);
        System.out.println(ListNode.printListNode(res));

    }
}
