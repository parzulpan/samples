void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.canWinNim(4));
  // case2
  print(solution.canWinNim(1));
  // case3
  print(solution.canWinNim(2));
}

class Solution {
  bool canWinNim(int n) {
    return n % 4 != 0;
  }
}
