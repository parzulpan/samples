import 'dart:math';

void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.stoneGameVII([5, 3, 1, 4, 2]));
  // case2
  print(solution.stoneGameVII([7, 90, 5, 1, 100, 10, 10, 2]));
}

class Solution {
  List<int> _s;
  List<List<int?>> _f;

  Solution()
      : _s = [],
        _f = [];

  int stoneGameVII(List<int> stones) {
    int n = stones.length;
    _s = List.filled(n + 1, 0);
    _f = List.generate(n, (index) => List<int?>.filled(n, null));

    for (var i = 0; i < n; i++) {
      _s[i + 1] = _s[i] + stones[i];
    }

    return _dfs(0, n - 1);
  }

  int _dfs(int i, int j) {
    if (i > j) {
      return 0;
    }
    if (_f[i][j] != null) {
      return _f[i][j]!;
    }

    int a = _s[j + 1] - _s[i + 1] - _dfs(i + 1, j);
    int b = _s[j] - _s[i] - _dfs(i, j - 1);
    _f[i][j] = max(a, b);

    return _f[i][j]!;
  }
}
