import 'dart:math';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.minOperationsMaxProfit([8, 3], 5, 6));
  // case2
  print(solution.minOperationsMaxProfit([10, 9, 6], 6, 4));
  // case3
  print(solution.minOperationsMaxProfit([3, 4, 0, 5, 1], 1, 92));
}

class Solution {
  int minOperationsMaxProfit(
      List<int> customers, int boardingCost, int runningCost) {
    int ans = -1;
    // 最大利润，当前利润
    int mx = 0, t = 0;
    // 等待的游客，当前转的次数
    int wait = 0, i = 0;
    while (wait > 0 || i < customers.length) {
      // 累加等待的游客以及新到达的游客，然后最多 4 个上摩天轮
      wait += i < customers.length ? customers[i] : 0;
      int up = min(4, wait);

      ++i;

      // 更新等待的游客数和利润
      wait -= up;
      t += up * boardingCost - runningCost;

      // 记录最大利润预期对应的轮转次数
      if (t > mx) {
        mx = t;
        ans = i;
      }
    }

    return ans;
  }
}
