void main(List<String> args) {
  Solution solution = Solution();

  print(solution.buyChoco([1, 2, 2], 3));
  print(solution.buyChoco([3, 2, 3], 3));
}

class Solution {
  int buyChoco(List<int> prices, int money) {
    prices.sort();

    for (var i = 0; i < prices.length - 1; i++) {
      if (prices[i] + prices[i + 1] <= money) {
        return money - (prices[i] + prices[i + 1]);
      }
    }

    return money;
  }
}
