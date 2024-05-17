package arraystring;

import java.util.Arrays;

public class daily826 {
    public static void main(String[] args) {

    }
}

class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // 安排工作以达到最大收益
        // 思路：排序+双指针
        // 1. 将工作按照能力升序排列，然后将工作按照难度升序排列。
        // 2. 遍历工人，对于每个工人，找出他能完成的工作中收益最大的那个，然后将这个收益加到答案中。

        Arrays.sort(worker);

        int n = profit.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { difficulty[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int ans = 0, mx = 0, i = 0;
        for (int w : worker) {
            while (i < n && jobs[i][0] <= w) {
                mx = Math.max(mx, jobs[i++][1]);
            }
            ans += mx;
        }

        return ans;
    }
}
