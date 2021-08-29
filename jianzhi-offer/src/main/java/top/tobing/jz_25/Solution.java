package top.tobing.jz_25;

import top.tobing.ListNode;

/**
 * @author tobing
 * @date 2021/8/29 10:10
 * @description
 */
public class Solution {
    /**
     * 简单双指针
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.generateList(4);
        ListNode l2 = ListNode.generateList(5);
        System.out.println(ListNode.printListNode(l1));
        System.out.println(ListNode.printListNode(l2));

        ListNode res = new Solution().mergeTwoLists(l1, l2);
        System.out.println(ListNode.printListNode(res));
    }

}
