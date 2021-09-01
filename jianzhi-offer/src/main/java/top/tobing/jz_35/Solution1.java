package top.tobing.jz_35;


/**
 * @author tobing
 * @date 2021/9/1 13:23
 * @description
 */
public class Solution1 {


    /**
     * 拼接+拆分法(三轮遍历)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一轮遍历：复制
        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            // 走两步
            cur = cur.next.next;
        }
        // 第二轮遍历：维护新链表random
        cur = head;
        while (cur != null) {
            Node copyNode = cur.next;
            copyNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // 第三轮遍历：拆分新链表
        Node res = head.next;
        Node newCur = head.next;
        cur = head;

        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            newCur.next = newCur.next == null ? null : newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return res;
    }
}
