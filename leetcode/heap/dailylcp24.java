package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class dailylcp24 {
    public static void main(String[] args) {
        SolutionLcp24 solution = new SolutionLcp24();

        // case1
        System.out.println(Arrays.toString(solution.numsGame(new int[] { 3, 4, 5, 1, 6, 7 })));
        // case2
        System.out.println(Arrays.toString(solution.numsGame(new int[] { 1, 2, 3, 4, 5 })));
        // case3
        System.out.println(Arrays.toString(solution.numsGame(new int[] { 1, 1, 1, 2, 3, 4 })));
    }
}

class SolutionLcp24 {
    public int[] numsGame(int[] nums) {
        // 思路：
        // 1. 转换
        // 2. 中位数贪心
        // 3. 对顶堆维护动态中位数
        final int MOD = 1_000_000_007;
        int[] ans = new int[nums.length];
        // 维护较小的一般，大根堆
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) { // 前缀长度是奇数
                if (!left.isEmpty() && b < left.peek()) {
                    leftSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rightSum += b;
                right.offer(b);
                ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
            } else { // 前缀长度是偶数
                if (b > right.peek()) {
                    rightSum += b - right.peek();
                    right.offer(b);
                    b = right.poll();
                }
                leftSum += b;
                left.offer(b);
                ans[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }

        return ans;
    }
}
