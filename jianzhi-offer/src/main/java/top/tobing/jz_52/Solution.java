package top.tobing.jz_52;

import top.tobing.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/20 12:01
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Solution {

    /**
     * 辅助Set
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
