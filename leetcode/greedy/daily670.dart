void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.maximumSwap(2736));
  // case2
  print(solution.maximumSwap(9973));
}

class Solution {
  int maximumSwap(int num) {
    List<int> s = num.toString().split('').map((e) => int.parse(e)).toList();
    int n = s.length;
    List<int> d = List<int>.generate(n, (i) => i);
    for (var i = n - 2; i >= 0; i--) {
      if (s[i] <= s[d[i + 1]]) {
        d[i] = d[i + 1];
      }
    }
    for (var i = 0; i < n; i++) {
      int j = d[i];
      if (s[i] < s[j]) {
        int t = s[i];
        s[i] = s[j];
        s[j] = t;
        break;
      }
    }

    return int.parse(s.join());
  }
}
