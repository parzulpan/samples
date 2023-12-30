void main(List<String> args) {
  Solution solution = Solution();

  print(solution.dayOfTheWeek(31, 8, 2019));
  print(solution.dayOfTheWeek(18, 7, 1999));
  print(solution.dayOfTheWeek(15, 8, 1993));
}

class Solution {
  String dayOfTheWeek(int day, int month, int year) {
    var dateTime = DateTime(year, month, day);

    List<String> weekdays = [
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday",
      "Sunday"
    ];

    return weekdays[dateTime.weekday - 1];
  }
}
