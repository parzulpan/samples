void main(List<String> args) {
  var solution = Solution();

  // case1
  print(solution.isWinner([4, 10, 7, 9], [6, 5, 2, 3]));

  // case2
  print(solution.isWinner([3, 5, 7, 6], [8, 10, 10, 2]));

  // case3
  print(solution.isWinner([2, 3], [4, 1]));

  // case4
  print(solution.isWinner([3, 6, 10, 8], [9, 9, 9, 9]));
}

class Solution {
  int isWinner(List<int> player1, List<int> player2) {
    var score1 = score(player1);
    var score2 = score(player2);

    return score1 > score2
        ? 1
        : score1 < score2
            ? 2
            : 0;
  }

  int score(List<int> player) {
    int index = -3;
    int score = 0;
    for (var i = 0; i < player.length; i++) {
      if (i - index <= 2) {
        score += (2 * player[i]);
      } else {
        score += player[i];
      }

      if (player[i] == 10) {
        index = i;
      }
    }

    return score;
  }
}
