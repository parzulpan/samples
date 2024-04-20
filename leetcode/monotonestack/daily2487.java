package monotonestack;

import java.util.ArrayDeque;
import java.util.ArrayList;

import common.ListNode;

public class daily2487 {
    public static void main(String[] args) {
        Solution2487 solution = new Solution2487();

        // case1
        System.out.println(solution.removeNodes(ListNode.init(new int[] { 5, 2, 13, 3, 8 })));
        // case2
        System.out.println(solution.removeNodes(ListNode.init(new int[] { 1, 1, 1, 1 })));
    }
}

class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
        for (Integer num : nums) {
            while (!stk.isEmpty() && stk.peekLast() < num) {
                stk.pollLast();
            }
            stk.offerLast(num);
        }

        ListNode dummy = new ListNode();
        head = dummy;
        while (!stk.isEmpty()) {
            head.next = new ListNode(stk.pollFirst());
            head = head.next;
        }

        return dummy.next;
    }
}
