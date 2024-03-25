package common;

/**
 * Ha 链表
 */
public class HaListNode {
    int val; // 节点值
    HaListNode next; // 指向下一节点的引用

    // 构造函数
    HaListNode(int x) {
        val = x;
    }

    /**
     * 在链表的节点 n0 之后插入节点 P
     */
    void insert(HaListNode n0, HaListNode P) {
        HaListNode n1 = n0.next;
        P.next = n1;
        n0.next = P;
    }

    /**
     * 删除链表的节点 n0 之后的首个节点
     */
    void remove(HaListNode n0) {
        if (n0.next == null) {
            return;
        }
        HaListNode P = n0.next;
        HaListNode n1 = P.next;
        n0.next = n1;
    }

    /**
     * 访问链表中索引为 index 的节点
     */
    HaListNode accesss(HaListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        return head;
    }

    /**
     * 在链表中查找值为 target 的首个节点
     */
    int find(HaListNode head, int target) {
        int index = 0;
        while (head != null) {
            if (head.val == target) {
                return index;
            }
            head = head.next;
            index++;
        }

        return -1;
    }

}
