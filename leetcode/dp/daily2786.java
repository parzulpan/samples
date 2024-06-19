package dp;

import java.util.Arrays;

public class daily2786 {
    public static void main(String[] args) {

    }
}

class Solution2786 {
    public long maxScore(int[] nums, int x) {
        // 访问数组中的位置使分数最大
        // 思路：递归搜索 + 保存递归返回值

        int n = nums.length;
        long[][] memo = new long[n][2];
        for (long[] m : memo) {
            // -1 表示没有计算过
            Arrays.fill(m, -1);
        }

        return dfs(0, nums[0] % 2, nums, x, memo);
    }

    private long dfs(int i, int j, int[] nums, int x, long[][] memo) {
        if (i == nums.length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (nums[i] % 2 != j) {
            return memo[i][j] = dfs(i + 1, j, nums, x, memo);
        }
        long res1 = dfs(i + 1, j, nums, x, memo);
        long res2 = dfs(i + 1, j ^ 1, nums, x, memo);

        return memo[i][j] = Math.max(res1, res2 - x) + nums[i];
    }
}
