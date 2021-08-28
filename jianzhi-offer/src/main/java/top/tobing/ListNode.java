package top.tobing;

/**
 * @author tobing
 * @date 2021/8/28 10:33
 * @description
 */
public class ListNode {
    int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode generateList(int end) {
        ListNode temp = new ListNode(1);
        ListNode head = temp;
        for (int i = 0; i < end; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }

    public static String printListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append("->");
            listNode = listNode.next;
        }
        sb.append("NULL\n");
        return sb.toString();
    }
}
