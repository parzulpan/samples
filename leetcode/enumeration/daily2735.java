package enumeration;

public class daily2735 {
    public static void main(String[] args) {
        Solution2735 solution = new Solution2735();

        // case1
        System.out.println(solution.minCost(new int[] { 20, 1, 15 }, 5));

        // case2
        System.out.println(solution.minCost(new int[] { 1, 2, 3 }, 4));
    }
}

class Solution2735 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[][] f = new int[n][n];

        for (int i = 0; i < n; i++) {
            f[i][0] = nums[i];
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j - 1], nums[(i - j + n) % n]);
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long cost = 1L * x * i;
            for (int j = 0; j < n; j++) {
                cost += f[j][i];
            }
            ans = Math.min(ans, cost);
        }

        return ans;
    }
}
