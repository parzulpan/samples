void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.maximumNumberOfStringPairs(["cd", "ac", "dc", "ca", "zz"]));
  // case2
  print(solution.maximumNumberOfStringPairs(["ab", "ba", "cc"]));
  // case3
  print(solution.maximumNumberOfStringPairs(["aa", "ab"]));
}

class Solution {
  int maximumNumberOfStringPairs(List<String> words) {
    int ans = 0;
    Set<String> set = Set();
    for (var word in words) {
      // 单词反转
      String wordR = String.fromCharCodes(word.runes.toList().reversed);
      if (set.contains(wordR)) {
        set.remove(wordR);
        ans++;
      } else {
        set.add(word);
      }
    }

    return ans;
  }
}
