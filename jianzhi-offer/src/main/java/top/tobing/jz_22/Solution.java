package top.tobing.jz_22;

import top.tobing.ListNode;

/**
 * @author tobing
 * @date 2021/8/28 10:32
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Solution {


    private int k;

    /**
     * 全局变量法
     * 将k赋值给全局变量，递归到底每次返回一个节点的时候，将k--
     * 当k<0时，为倒数第k+1个元素，其next为第k个元素，此时直接返回head.next;
     * 否则，直接返回了head元素即可
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        this.k = k;
        return recur(head);
    }

    private ListNode recur(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tmp = recur(head.next);
        return --k < 0 ? tmp : head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.generateList(10);
        System.out.println(ListNode.printListNode(listNode));
        ListNode res = new Solution().getKthFromEnd(listNode, 2);
        System.out.println(ListNode.printListNode(res));
    }
}
