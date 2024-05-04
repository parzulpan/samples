package dp;

import java.util.Arrays;

public class daily1235 {
    public static void main(String[] args) {

    }
}

class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 规划兼职工作
        // 思路：动态规划 + 二分查找
        // 1. 初始化 jobs(startTime,endTime,profit)，按照 endTime 从小到大排序 jobs
        // 2. 定义 dp[i] 表示前 i 份工作中，可以获得的最大报酬，dp[0] = 0，即结果为 dp[n]
        // 3. 对于第 i 份工作，
        // 如果不做，最大报酬即为 dp[i]，
        // 如果做，通过二分查找，找到第 i 份工作开始时间之前结束的最后一份工作，记为 j，那么最大报酬即为 dp[j] + profit[i]
        // 最终最大报酬取 max 即可

        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = binarySearch(jobs, jobs[i][0], i);
            dp[i + 1] = Math.max(dp[i], dp[j] + jobs[i][2]);
        }

        return dp[n];
    }

    private int binarySearch(int[][] jobs, int x, int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (jobs[mid][1] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
