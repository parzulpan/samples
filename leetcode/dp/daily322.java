package dp;

import java.util.Arrays;

public class daily322 {
    public static void main(String[] args) {
        Solution322 solution = new Solution322();

        // case1
        System.out.println(solution.coinChange(new int[] { 1, 2, 5 }, 11));

        // case2
        System.out.println(solution.coinChange(new int[] { 2 }, 3));

        // case3
        System.out.println(solution.coinChange(new int[] { 1 }, 0));
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        // 零钱兑换
        // 思路：完全背包 DP

        final int inf = 1 << 30;
        int n = amount;
        int[] f = new int[n + 1];
        Arrays.fill(f, inf);

        f[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                f[j] = Math.min(f[j], f[j - coin] + 1);
            }
        }

        return f[n] >= inf ? -1 : f[n];
    }
}
