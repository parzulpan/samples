void main(List<String> args) {
  Solution solution = Solution();

  // case1
  print(solution.dayOfYear('2019-01-09'));
  // case2
  print(solution.dayOfYear('2019-02-10'));
  // case3
  print(solution.dayOfYear('2023-12-31'));
}

class Solution {
  int dayOfYear(String date) {
    DateTime dateTime = DateTime.parse(date);

    // 没有相应的库函数能直接得到，所以转一下
    DateTime firstDayOfYear = DateTime(dateTime.year);

    return dateTime.difference(firstDayOfYear).inDays + 1;
  }
}
