void main(List<String> args) {
  Solution solution = Solution();

  // case1
  print(solution.validPartition([4, 4, 4, 5, 6]));
  // case2
  print(solution.validPartition([1, 1, 1, 2]));
}

class Solution {
  bool validPartition(List<int> nums) {
    int n = nums.length;
    var f = List<bool>.filled(n + 1, false);
    f[0] = true;
    for (var i = 1; i < n; i++) {
      if (f[i - 1] && nums[i] == nums[i - 1] ||
          i > 1 &&
              f[i - 2] &&
              (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                  nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
        f[i + 1] = true;
      }
    }

    return f[n];
  }
}
