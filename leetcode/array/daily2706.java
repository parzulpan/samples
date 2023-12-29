package array;

import java.util.Arrays;

public class daily2706 {
    public static void main(String[] args) {
        Solution2706 solution = new Solution2706();

        System.out.println(solution.buyChoco(new int[] { 1, 2, 2 }, 3));
        System.out.println(solution.buyChoco(new int[] { 3, 2, 3 }, 3));
    }
}

class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] + prices[i + 1] <= money) {
                return money - (prices[i] + prices[i + 1]);
            }
        }

        return money;
    }
}
