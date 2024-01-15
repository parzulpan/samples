class ListNode {
  int val;
  ListNode? next;

  // Dart 的构造函数
  ListNode([this.val = 0, this.next]);

  // 用数组初始化一个单链表
  static ListNode? init(List<int> arr) {
    if (arr.isEmpty) {
      return null;
    }

    ListNode head = ListNode(arr[0]);
    ListNode current = head;

    for (int i = 1; i < arr.length; i++) {
      current.next = ListNode(arr[i]);
      current = current.next!;
    }

    return head;
  }

  // 获取值
  int get value => val;

  // 获取下一个节点
  ListNode? get nextNode => next;

  @override
  String toString() {
    if (next != null) {
      return 'ListNode(val: $val, next: $next)';
    } else {
      return 'ListNode(val: $val)';
    }
  }
}
