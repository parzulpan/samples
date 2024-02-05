package dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class daily1696 {
    public static void main(String[] args) {
        Solution1696 solution = new Solution1696();

        // case1
        System.out.println(solution.maxResult(new int[] { 1, -1, -2, 4, -7, 3 }, 2));
        // case2
        System.out.println(solution.maxResult(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
        // case3
        System.out.println(solution.maxResult(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));
    }
}

class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        // f[i] 表示到达下标 i 的最大得分
        // f[i] 可有 f[j] 转移而来，其中 j 满足 i - k <= j <= i - 1
        // 状态转移方程为：f[i] = max(f[j]) + nums[i];
        int[] f = new int[n];

        // 用一个单调递减的队列存储下标 j，那么队首就是 f[j] 的最大值
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);

        for (int i = 0; i < n; i++) {
            // 下标 j 不满足条件则出队
            if (i - k > q.peekFirst()) {
                q.pollFirst();
            }
            f[i] = nums[i] + f[q.peekFirst()];
            // 维护单调递减的队列
            while (!q.isEmpty() && f[q.peekLast()] <= f[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }

        return f[n - 1];
    }
}
