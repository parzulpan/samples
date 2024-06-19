package dp;

public class daily312 {
    public static void main(String[] args) {

    }
}

class Solution312 {
    public int maxCoins(int[] nums) {
        // 戳气球
        // 思路：动态规划
        // 1. 定义 f[i][j] 表示戳破区间 [i,j] 内的所有气球能得到的最多硬币数，那么答案即为 f[0][n+1]。
        // 2. 状态转移方程：f[i][j]=max(f[i][j],f[i][k]+f[k][j]+arr[i]×arr[k]×arr[j])
        // 3. 最后，我们返回 f[0][n+1] 即可

        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        int[][] f = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }

        return f[0][n + 1];
    }
}
