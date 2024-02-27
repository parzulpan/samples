void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.stoneGameVI([1, 3], [2, 1]));
  // case2
  print(solution.stoneGameVI([1, 2], [3, 1]));
  // case3
  print(solution.stoneGameVI([2, 4, 3], [1, 6, 7]));
}

class Solution {
  int stoneGameVI(List<int> aliceValues, List<int> bobValues) {
    int n = aliceValues.length;
    List<List<int>> values =
        List.generate(n, (i) => [aliceValues[i] + bobValues[i], i]);
    values.sort((a, b) => b[0].compareTo(a[0]));
    int a = 0, b = 0;
    for (int k = 0; k < n; k++) {
      int i = values[k][1];
      if (k % 2 == 0) {
        a += aliceValues[i];
      } else {
        b += bobValues[i];
      }
    }

    if (a == b) {
      return 0;
    } else {
      return a > b ? 1 : -1;
    }
  }
}
