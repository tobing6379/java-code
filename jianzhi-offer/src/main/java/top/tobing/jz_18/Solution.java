package top.tobing.jz_18;

/**
 * @author tobing
 * @date 2021/8/10 8:59
 * @description 剑指 Offer 18. 删除链表的节点
 */
public class Solution {

    /**
     * 简单递归法
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 终止条件
        if (head == null) {
            return head;
        }
        // 当前节点为删除节点，直接返回当前节点的下一个节点
        if (head.val == val) {
            return head.next;
        }
        // 否则将当前节点的下一个节点赋值给下一个节点执行的结果
        head.next = deleteNode(head.next, val);
        return head;
    }


    public static void main(String[] args) {
        ListNode list = createList();
        printList(list);
        ListNode newList = new Solution().deleteNode(list, 0);
        printList(newList);
    }

    /**
     * 构造一个链表
     */
    private static ListNode createList() {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return res;
    }

    /**
     * 打印一个链表
     */
    private static void printList(ListNode node) {
        StringBuilder res = new StringBuilder();
        while (node != null) {
            res.append(node.val);
            res.append(",");
            node = node.next;
        }
        System.out.println(res.toString());
    }
}
