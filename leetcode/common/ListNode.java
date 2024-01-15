package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 用数组初始化一个单链表
     */
    public static ListNode init(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
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
    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", " + (next != null ? "next=" + next : "") + "]";
    }
}
