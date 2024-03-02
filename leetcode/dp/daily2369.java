package dp;

public class daily2369 {
    public static void main(String[] args) {
        Solution2369 solution = new Solution2369();

        // case1
        System.out.println(solution.validPartition(new int[] { 4, 4, 4, 5, 6 }));
        // case2
        System.out.println(solution.validPartition(new int[] { 1, 1, 1, 2 }));
    }
}

class Solution2369 {
    public boolean validPartition(int[] nums) {
        // 检查数组是否存在有效划分
        // 思路：动态规划
        // 1. nums 的前 i 个数能否有效划分
        // 2. 定义 f[0]=true，f[i+1] 表示能否有效划分 nums[0] 到 nums[i]
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            if (f[i - 1] && nums[i] == nums[i - 1] ||
                    i > 1 && f[i - 2] &&
                            (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                                    nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
                f[i + 1] = true;
            }
        }

        return f[n];
    }
}
