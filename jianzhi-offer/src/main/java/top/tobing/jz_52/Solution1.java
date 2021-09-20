package top.tobing.jz_52;

import top.tobing.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/20 12:01
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Solution1 {

    /**
     * 双指针
     * A指针做完链表A之后继续走链表B
     * B指针走完链表B之后继续走链表A
     * 无论两链表是否相交，两个指针走的节点数是一样的；
     * 如果相交，则会提前介绍；如果不相交，最终遇到null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }
}
