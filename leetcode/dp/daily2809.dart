import 'dart:math';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.minimumTime([1, 2, 3], [1, 2, 3], 4));
  // case2
  print(solution.minimumTime([1, 2, 3], [3, 3, 3], 4));
}

class Solution {
  int minimumTime(List<int> nums1, List<int> nums2, int x) {
    int n = nums1.length;
    List<List<int>> f = List.generate(n + 1, (_) => List.filled(n + 1, 0));
    List<List<int>> nums =
        List.generate(n, (index) => [nums1[index], nums2[index]]);

    nums.sort((a, b) => a[1].compareTo(b[1]));

    for (var i = 1; i <= n; i++) {
      for (var j = 0; j <= n; j++) {
        f[i][j] = f[i - 1][j];
        if (j > 0) {
          int a = nums[i - 1][0], b = nums[i - 1][1];
          f[i][j] = max(f[i][j], f[i - 1][j - 1] + a + b * j);
        }
      }
    }

    int s1 = 0, s2 = 0;
    for (var v in nums1) {
      s1 += v;
    }
    for (var v in nums2) {
      s2 += v;
    }

    for (var j = 0; j <= n; j++) {
      if (s1 + s2 * j - f[n][j] <= x) {
        return j;
      }
    }

    return -1;
  }
}
