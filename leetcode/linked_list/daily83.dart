import '../common/ListNode.dart';

void main(List<String> args) {
  var solution = Solution();

  // case1
  var node1 = ListNode.init([1, 1, 2]);
  print(solution.deleteDuplicates(node1));

  // case2
  var node2 = ListNode.init([1, 1, 2, 3, 3]);
  print(solution.deleteDuplicates(node2));
}

class Solution {
  ListNode? deleteDuplicates(ListNode? head) {
    ListNode? cur = head;

    while (cur != null && cur.next != null) {
      if (cur.val == cur.next!.val) {
        cur.next = cur.next!.next;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }
}
