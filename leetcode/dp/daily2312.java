package dp;

public class daily2312 {
    public static void main(String[] args) {
        Solution2312 solution = new Solution2312();

        // case1
        System.out.println(solution.sellingWood(3, 5, new int[][] { { 1, 4, 2 }, { 2, 2, 7 }, { 2, 1, 3 } }));

        // case2
        System.out.println(solution.sellingWood(4, 6, new int[][] { { 3, 2, 10 }, { 1, 4, 2 }, { 4, 1, 3 } }));
    }
}

class Solution2312 {
    public long sellingWood(int m, int n, int[][] prices) {
        // 卖木头块
        // 思路：动态规划
        // 1. ctrl c

        int[][] d = new int[m + 1][n + 1];
        long[][] f = new long[m + 1][n + 1];
        for (int[] p : prices) {
            d[p[0]][p[1]] = p[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = d[i][j];
                for (int k = 1; k < i; k++) {
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                }
            }
        }

        return f[m][n];
    }
}
