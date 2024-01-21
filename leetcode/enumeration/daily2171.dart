import 'dart:math';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.minimumRemoval([4, 1, 6, 5]));
  // case2
  print(solution.minimumRemoval([2, 10, 3, 2]));
}

class Solution {
  int minimumRemoval(List<int> beans) {
    beans.sort();
    int sum = 0, maxV = 0;
    int n = beans.length;
    for (var i = 0; i < n; i++) {
      sum += beans[i];
      maxV = max(maxV, (n - i) * beans[i]);
    }

    return sum - maxV;
  }
}
