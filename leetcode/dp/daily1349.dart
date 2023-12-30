import 'dart:math';

void main(List<String> args) {
  Solution solution = Solution();

  // case1
  print(solution.maxStudents([
    ['#', '.', '#', '#', '.', '#'],
    ['.', '#', '#', '#', '#', '.'],
    ['#', '.', '#', '#', '.', '#']
  ]));

  // case2
  print(solution.maxStudents([
    ['.', '#'],
    ['#', '#'],
    ['#', '.'],
    ['#', '#'],
    ['.', '#']
  ]));

  // case3
  print(solution.maxStudents([
    ['#', '.', '.', '.', '#'],
    ['.', '#', '.', '#', '.'],
    ['.', '.', '#', '.', '.'],
    ['.', '#', '.', '#', '.'],
    ['#', '.', '.', '.', '#']
  ]));
}

class Solution {
  int maxStudents(List<List<String>> seats) {
    int m = seats.length;
    int n = seats[0].length;

    List<int> a = List<int>.filled(m, 0);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (seats[i][j] == '.') {
          a[i] |= 1 << j;
        }
      }
    }

    List<List<int>> f = List.generate(m, (_) => List<int>.filled(1 << n, 0));
    for (int j = 1; j < (1 << n); j++) {
      int lb = j & -j;
      f[0][j] = f[0][j & ~(lb * 3)] + 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = a[i]; j > 0; j = (j - 1) & a[i]) {
        f[i][j] = f[i - 1][a[i - 1]];
        for (int s = j; s > 0; s = (s - 1) & j) {
          if ((s & (s >> 1)) == 0) {
            int t = a[i - 1] & ~(s << 1 | s >> 1);
            f[i][j] = max(f[i][j], f[i - 1][t] + f[0][s]);
          }
        }
      }
      f[i][0] = f[i - 1][a[i - 1]];
    }

    return f[m - 1][a[m - 1]];
  }
}
