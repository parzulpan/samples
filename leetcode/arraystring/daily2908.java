package arraystring;

public class daily2908 {
    public static void main(String[] args) {
        Solution2908 solution = new Solution2908();

        // case1
        System.out.println(solution.minimumSum(new int[] { 8, 6, 1, 5, 3 }));
        // case2
        System.out.println(solution.minimumSum(new int[] { 5, 4, 8, 7, 10, 2 }));
        // case3
        System.out.println(solution.minimumSum(new int[] { 6, 5, 4, 3, 4, 5 }));
    }
}

class Solution2908 {
    public int minimumSum(int[] nums) {
        // 元素和最小的山形三元组 I
        // 思路：预处理+枚举
        // 1. 预处理出每个位置右侧的最小值，记录 right[i] = min(nums[i+1...n−1])
        // 2. 遍历数组，记录 left = min(nums[0...i−1])，记录 ans 为最小元素和并更新

        int n = nums.length;
        int[] right = new int[n + 1];
        final int inf = Integer.MAX_VALUE;
        right[n] = inf;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }

        int ans = inf, left = inf;
        for (int i = 0; i < n; i++) {
            if (left < nums[i] && right[i + 1] < nums[i]) {
                ans = Math.min(ans, left + nums[i] + right[i + 1]);
            }
            left = Math.min(left, nums[i]);
        }

        return ans == inf ? -1 : ans;
    }
}
