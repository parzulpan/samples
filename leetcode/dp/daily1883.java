package dp;

import java.util.Arrays;
import java.util.Objects;

public class daily1883 {
    public static void main(String[] args) {
        Boolean x = false;
        int y = 0;
        System.out.println(Objects.equals(x, y));

    }
}

class Solution1883 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        // 准时抵达会议现场的最小跳过休息次数
        // 思路：DP

        int n = dist.length;
        double[][] f = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], 1e20);
        }
        f[0][0] = 0;
        double eps = 1e-8;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j < i) {
                    f[i][j] = Math.min(
                            f[i][j], Math.ceil(f[i - 1][j]) + 1.0 * dist[i - 1] / speed - eps);
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1.0 * dist[i - 1] / speed);
                }
            }
        }
        for (int j = 0; j <= n; ++j) {
            if (f[n][j] <= hoursBefore + eps) {
                return j;
            }
        }
        return -1;

    }
}
