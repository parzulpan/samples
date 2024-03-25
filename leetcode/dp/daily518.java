package dp;

public class daily518 {
    public static void main(String[] args) {
        Solution518 solution = new Solution518();

        // case1
        System.out.println(solution.change(5, new int[] { 1, 2, 5 }));
        // case1
        System.out.println(solution.change(3, new int[] { 2 }));
        // case1
        System.out.println(solution.change(10, new int[] { 10 }));

    }
}

class Solution518 {
    public int change(int amount, int[] coins) {
        // 零钱兑换 II
        // 思路：完全背包 DP

        int n = amount;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                f[i] += f[i - coin];
            }
        }

        return f[n];
    }
}
