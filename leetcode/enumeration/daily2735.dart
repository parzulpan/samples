import 'dart:math';

void main(List<String> args) {
  Solution solution = Solution();

  // case1
  print(solution.minCost([20, 1, 15], 5));

  // case2
  print(solution.minCost([1, 2, 3], 4));
}

class Solution {
  int minCost(List<int> nums, int x) {
    int n = nums.length;
    List<List<int>> f = List.generate(n, (i) => List<int>.filled(n, 0));

    for (var i = 0; i < n; i++) {
      f[i][0] = nums[i];
      for (var j = 1; j < n; j++) {
        f[i][j] = min(f[i][j - 1], nums[(i - j + n) % n]);
      }
    }

    int ans = 1e18.toInt();
    for (var i = 0; i < n; i++) {
      int cost = x * i;
      for (var j = 0; j < n; j++) {
        cost += f[j][i];
      }
      ans = min(ans, cost);
    }

    return ans;
  }
}
