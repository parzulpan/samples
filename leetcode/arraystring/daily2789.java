package arraystring;

public class daily2789 {
    public static void main(String[] args) {
        Solution2789 solution = new Solution2789();

        // case1
        System.out.println(solution.maxArrayValue(new int[] { 2, 3, 7, 9, 3 }));

        // case1
        System.out.println(solution.maxArrayValue(new int[] { 5, 3, 3 }));
    }
}

class Solution2789 {
    public long maxArrayValue(int[] nums) {
        // 合并后数组中的最大元素
        // 思路：倒序模拟合并
        // 1. 为了最大化合并后的数组中的最大元素，应该先合并右侧的元素
        // 2. 然后按照题意模拟即可

        int n = nums.length;
        long ans = nums[n - 1], t = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= t) {
                t += nums[i];
            } else {
                t = nums[i];
            }

            ans = Math.max(ans, t);
        }

        return ans;
    }
}
