package greedy;

import java.util.Arrays;

public class daily3111 {
    public static void main(String[] args) {

    }
}

class Solution3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        // 覆盖所有点的最少矩形数目
        // 思路：贪心

        Arrays.sort(points, (p, q) -> p[0] - q[0]);
        int ans = 0;
        int x2 = -1;
        for (int[] p : points) {
            if (p[0] > x2) {
                ans++;
                x2 = p[0] + w;
            }
        }

        return ans;
    }
}
