package top.tobing.jz_35;


import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/1 13:23
 * @description
 */
public class Solution {

    private Map<Node, Node> map = new HashMap<>();

    /**
     * 双遍历+辅助map
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一轮遍历，建立new节点与old节点的联系map
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 第二轮遍历，根据map还原next与random
        cur = head;
        Node dummy = new Node(-1);
        Node curNew = dummy;
        while (cur != null) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
            curNew.next = newCur;
            curNew = curNew.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
