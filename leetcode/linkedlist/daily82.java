import common.ListNode;

public class daily82 {
    public static void main(String[] args) {
        Solution82 solution = new Solution82();

        // case1
        System.out.println(solution.deleteDuplicates(ListNode.init(new int[] { 1, 2, 3, 3, 4, 4, 5 })));
        // case2
        System.out.println(solution.deleteDuplicates(ListNode.init(new int[] { 1, 1, 1, 2, 3 })));
    }
}

class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
