package greedy;

public class daily1690 {
    public static void main(String[] args) {
        Solution1690 solution = new Solution1690();

        // case1
        System.out.println(solution.stoneGameVII(new int[] { 5, 3, 1, 4, 2 }));
        // case2
        System.out.println(solution.stoneGameVII(new int[] { 7, 90, 5, 1, 100, 10, 10, 2 }));
    }
}

class Solution1690 {
    private int[] s;
    private Integer[][] f;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        s = new int[n + 1];
        f = new Integer[n][n];
        // 先计算出前缀和
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }

        //
        return dfs(0, n - 1);
    }

    /**
     * 当剩下的石子为 stones[i],…,stones[j] 时，先手与后手的得分差值
     */
    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }

        if (f[i][j] != null) {
            return f[i][j];
        }

        // 先手有两种选择，分别是移除 stones[i] 或 stones[j]，然后计算得分差值，取两者中的较大值作为返回值
        int a = s[j + 1] - s[i + 1] - dfs(i + 1, j);
        int b = s[j] - s[i] - dfs(i, j - 1);
        f[i][j] = Math.max(a, b);

        return f[i][j];
    }
}
