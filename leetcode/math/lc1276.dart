void main(List<String> args) {
  var so = Solution();

  var ans1 = so.numOfBurgers(16, 7);
  print(ans1);

  var ans2 = so.numOfBurgers(17, 4);
  print(ans2);

  var ans3 = so.numOfBurgers(4, 17);
  print(ans3);
}

class Solution {
  List<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
    if (tomatoSlices % 2 != 0 ||
        tomatoSlices < cheeseSlices * 2 ||
        cheeseSlices * 4 < tomatoSlices) {
      return <int>[];
    }

    var ans = <int>[];
    ans.add(tomatoSlices ~/ 2 - cheeseSlices);
    ans.add(cheeseSlices * 2 - tomatoSlices ~/ 2);

    return ans;
  }
}
