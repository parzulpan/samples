package arraystring;

import java.util.Arrays;

public class daily2580 {
    public static void main(String[] args) {

    }
}

class Solution2580 {
    public int countWays(int[][] ranges) {
        // 统计将重叠区间合并成组的方案数
        // 思路：合并区间

        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int ans = 1;
        int maxR = -1;

        for (int[] p : ranges) {
            // 无法合并
            if (p[0] > maxR) {
                // 新区间
                ans = ans * 2 % 1_000_000_007;
            }
            // 合并
            maxR = Math.max(maxR, p[1]);
        }

        return ans;
    }
}