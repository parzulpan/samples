package common;

/**
 * Pan 链表
 */
public class PanListNode {
    public int val;
    public PanListNode next;

    public PanListNode() {
    }

    public PanListNode(int val) {
        this.val = val;
    }

    public PanListNode(int val, PanListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 用数组初始化一个单链表
     */
    public static PanListNode init(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        PanListNode head = new PanListNode(arr[0]);
        PanListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new PanListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * 获取值
     */
    public int getVal() {
        return val;
    }

    /**
     * 获取下一个节点
     */
    public PanListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", " + (next != null ? "next=" + next : "") + "]";
    }
}
