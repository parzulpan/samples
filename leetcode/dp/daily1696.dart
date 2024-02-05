import 'dart:collection';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.maxResult([1, -1, -2, 4, -7, 3], 2));
  // case2
  print(solution.maxResult([10, -5, -2, 4, 0, 3], 3));
  // case3
  print(solution.maxResult([1, -5, -20, 4, -1, 3, -6, -3], 2));
}

class Solution {
  int maxResult(List<int> nums, int k) {
    int n = nums.length;

    List<int> f = List<int>.filled(n, 0);

    Queue<int> q = Queue<int>();
    q.add(0);

    for (int i = 0; i < n; i++) {
      if (i - k > q.first) {
        q.removeFirst();
      }
      f[i] = nums[i] + f[q.first];
      while (q.isNotEmpty && f[q.last] <= f[i]) {
        q.removeLast();
      }
      q.addLast(i);
    }

    return f[n - 1];
  }
}
