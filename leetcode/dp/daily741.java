package dp;

public class daily741 {
    public static void main(String[] args) {

    }
}

class Solution741 {
    public int cherryPickup(int[][] grid) {
        // 摘樱桃
        // 思路：动态规划
        // 1. ctrl c

        int n = grid.length;
        int[][][] f = new int[n * 2][n][n];
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int i1 = 0; i1 < n; ++i1) {
                for (int i2 = 0; i2 < n; ++i2) {
                    int j1 = k - i1, j2 = k - i2;
                    f[k][i1][i2] = Integer.MIN_VALUE;
                    if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n || grid[i1][j1] == -1
                            || grid[i2][j2] == -1) {
                        continue;
                    }
                    int t = grid[i1][j1];
                    if (i1 != i2) {
                        t += grid[i2][j2];
                    }
                    for (int x1 = i1 - 1; x1 <= i1; ++x1) {
                        for (int x2 = i2 - 1; x2 <= i2; ++x2) {
                            if (x1 >= 0 && x2 >= 0) {
                                f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][x1][x2] + t);
                            }
                        }
                    }
                }
            }
        }

        return Math.max(0, f[n * 2 - 2][n - 1][n - 1]);
    }
}
