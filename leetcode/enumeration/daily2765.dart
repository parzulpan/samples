import 'dart:math';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.alternatingSubarray([2, 3, 4, 3, 4]));
  // case2
  print(solution.alternatingSubarray([4, 5, 6]));
}

class Solution {
  int alternatingSubarray(List<int> nums) {
    int ans = -1;
    int n = nums.length;
    for (var i = 0; i < n; i++) {
      int k = 1;
      int j = i;
      for (; j + 1 < n && nums[j + 1] - nums[j] == k; j++) {
        k *= -1;
      }

      if (j - i + 1 > 1) {
        ans = max(ans, j - i + 1);
      }
    }

    return ans;
  }
}
