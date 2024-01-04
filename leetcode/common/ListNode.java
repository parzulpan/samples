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
     * @return the val
     */
    public int getVal() {
        return val;
    }

    /**
     * @return the next
     */
    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", " + (next != null ? "next=" + next : "") + "]";
    }
}
