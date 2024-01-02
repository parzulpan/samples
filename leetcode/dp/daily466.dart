void main(List<String> args) {
  Solution solution = Solution();

  // case1
  print(solution.getMaxRepetitions("acb", 4, "ab", 2));

  // case2
  print(solution.getMaxRepetitions("acb", 1, "acb", 1));
}

class Solution {
  int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int m = s1.length, n = s2.length;
    List<List<int>> dp = List.generate(n, (_) => List<int>.filled(0, 0));
    for (var i = 0; i < n; i++) {
      int j = i;
      int cnt = 0;
      for (var k = 0; k < m; k++) {
        if (s1[k] == s2[j]) {
          if (++j == n) {
            j = 0;
            ++cnt;
          }
        }
      }
      dp[i] = [cnt, j];
    }

    int ans = 0;
    for (var j = 0; n1 > 0; --n1) {
      ans += dp[j][0];
      j = dp[j][1];
    }

    return ans ~/ n2;
  }
}
