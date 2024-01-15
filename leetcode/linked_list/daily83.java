import common.ListNode;

public class daily83 {
    public static void main(String[] args) {
        Solution83 solution = new Solution83();

        // case1
        ListNode node1 = ListNode.init(new int[] { 1, 1, 2 });
        System.out.println(solution.deleteDuplicates(node1));

        // case2
        ListNode node2 = ListNode.init(new int[] { 1, 1, 2, 3, 3 });
        System.out.println(solution.deleteDuplicates(node2));
    }
}

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}