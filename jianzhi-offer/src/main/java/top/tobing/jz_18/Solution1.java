package top.tobing.jz_18;

/**
 * @author tobing
 * @date 2021/8/10 8:59
 * @description 剑指 Offer 18. 删除链表的节点
 */
public class Solution1 {

    /**
     * 迭代法
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 特殊情况判断
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        // 对于删除最后一位元素，在执行cur=cur.next之后，cur可能为空，不能直接判断cur.next!=null
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                // 跳过node.val=val的节点
                cur.next = cur.next.next;
            }
            // 当前元素移动到下一位
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode list = createList();
        printList(list);
        ListNode newList = new Solution1().deleteNode(list, 0);
        printList(newList);
    }

    /**
     * 构造一个链表
     */
    private static ListNode createList() {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int[] arr = {};
        for (int i = 0; i < arr.length; i++) {
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
