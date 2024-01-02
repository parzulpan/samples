package dp;

public class daily466 {
    public static void main(String[] args) {
        Solution466 solution = new Solution466();

        // case1
        System.out.println(solution.getMaxRepetitions("acb", 4, "ab", 2));

        // case2
        System.out.println(solution.getMaxRepetitions("acb", 1, "acb", 1));
    }
}

class Solution466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[n][0];
        for (int i = 0; i < n; i++) {
            int j = i;
            int cnt = 0;
            for (int k = 0; k < m; k++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    if (++j == n) {
                        j = 0;
                        ++cnt;
                    }
                }
            }
            dp[i] = new int[] { cnt, j };
        }

        int ans = 0;
        for (int j = 0; n1 > 0; --n1) {
            ans += dp[j][0];
            j = dp[j][1];
        }

        return ans / n2;
    }
}
