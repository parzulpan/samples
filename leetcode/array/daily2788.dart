void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution
      .splitWordsBySeparator(["one.two.three", "four.five", "six"], '.'));
  // case2
  print(solution.splitWordsBySeparator(["\$easy\$", "\$problem\$"], '\$'));
  // case3s
  print(solution.splitWordsBySeparator(["|||"], '|'));
}

class Solution {
  List<String> splitWordsBySeparator(List<String> words, String separator) {
    List<String> ans = [];
    for (var word in words) {
      List<String> split = word.split(separator);
      for (var s in split) {
        if (s.isNotEmpty && s != separator) {
          ans.add(s);
        }
      }
    }

    return ans;
  }
}
