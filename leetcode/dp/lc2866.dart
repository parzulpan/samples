import 'dart:math';

void main(List<String> args) {
  var solution = Solution();

  var case1 = [5, 3, 4, 1, 1];
  print(solution.maximumSumOfHeights(case1));

  var case2 = [6, 5, 3, 9, 2, 7];
  print(solution.maximumSumOfHeights(case2));

  var case3 = [3, 2, 5, 5, 2, 3];
  print(solution.maximumSumOfHeights(case3));
}

class Solution {
  int maximumSumOfHeights(List<int> maxHeights) {
    int size = maxHeights.length;
    List<int> stk = [];
    List<int> left = List.filled(size, -1);
    List<int> right = List.filled(size, size);

    for (var i = 0; i < size; i++) {
      int x = maxHeights[i];
      while (stk.isNotEmpty && maxHeights[stk.last] > x) {
        stk.removeLast();
      }
      if (stk.isNotEmpty) {
        left[i] = stk.last;
      }
      stk.add(i);
    }

    stk.clear();

    for (var i = size - 1; i >= 0; i--) {
      int x = maxHeights[i];
      while (stk.isNotEmpty && maxHeights[stk.last] >= x) {
        stk.removeLast();
      }
      if (stk.isNotEmpty) {
        right[i] = stk.last;
      }
      stk.add(i);
    }

    List<int> f = List.filled(size, 0);
    List<int> g = List.filled(size, 0);

    for (var i = 0; i < size; i++) {
      int x = maxHeights[i];
      if (i > 0 && x >= maxHeights[i - 1]) {
        f[i] = f[i - 1] + x;
      } else {
        int j = left[i];
        f[i] = x * (i - j) + (j >= 0 ? f[j] : 0);
      }
    }

    for (var i = size - 1; i >= 0; i--) {
      int x = maxHeights[i];
      if (i < size - 1 && x >= maxHeights[i + 1]) {
        g[i] = g[i + 1] + x;
      } else {
        int j = right[i];
        g[i] = x * (j - i) + (j < size ? g[j] : 0);
      }
    }

    int ans = 0;
    for (var i = 0; i < size; i++) {
      ans = max(ans, f[i] + g[i] - maxHeights[i]);
    }

    return ans;
  }
}
