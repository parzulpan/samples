package dp;

public class daily377 {
    public static void main(String[] args) {

    }
}

class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        // 组合总和 Ⅳ
        // 思路：动态规划
        // 1. 定义 f[i] 表示总和为 i 的元素组合的个数，初始时 f[0] = 1，其余 f[i] = 0，最终答案即为 f[target]
        // 2. 对于 f[i]，可以枚举数组中的每个元素 x，如果 i >= x，则 f[i] = f[i] + f[i-x]

        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : nums) {
                if (i >= x) {
                    f[i] += f[i - x];
                }
            }
        }

        return f[target];
    }
}
