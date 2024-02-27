void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.distinctDifferenceArray([1, 2, 3, 4, 5]));
  // case2
  print(solution.distinctDifferenceArray([3, 2, 3, 4, 2]));
}

class Solution {
  List<int> distinctDifferenceArray(List<int> nums) {
    var n = nums.length;
    var ans = List<int>.filled(n, 0);
    var sufSet = <int>{};
    var sufArr = List<int>.filled(n + 1, 0);
    for (var i = n - 1; i >= 0; i--) {
      sufSet.add(nums[i]);
      sufArr[i] = sufSet.length;
    }
    sufSet.clear();
    for (var i = 0; i < n; i++) {
      sufSet.add(nums[i]);
      ans[i] = sufSet.length - sufArr[i + 1];
    }

    return ans;
  }
}
