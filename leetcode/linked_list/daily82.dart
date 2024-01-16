import '../common/ListNode.dart';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.deleteDuplicates(ListNode.init([1, 2, 3, 3, 4, 4, 5])));
  // case2
  print(solution.deleteDuplicates(ListNode.init([1, 1, 1, 2, 3])));
}

class Solution {
  ListNode? deleteDuplicates(ListNode? head) {
    ListNode dummy = ListNode(0, head);
    ListNode? pre = dummy;
    ListNode? cur = head;

    while (cur != null) {
      while (cur?.next != null && cur?.next?.val == cur?.val) {
        cur = cur?.next;
      }

      if (pre?.next == cur) {
        pre = cur;
      } else {
        pre?.next = cur?.next;
      }
      cur = cur?.next;
    }

    return dummy.next;
  }
}
