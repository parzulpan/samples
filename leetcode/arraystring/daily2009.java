package arraystring;

import java.util.Arrays;

public class daily2009 {
    public static void main(String[] args) {

    }
}

class Solution2009 {
    public int minOperations(int[] nums) {
        // 使数组连续的最少操作数
        // 思路：排序 + 去重 + 双指针
        // 1. 先将数组排序并去重
        // 2. 遍历数组，枚举以当前元素 nums[i] 作为连续数组的最小值，
        // 通过双指针找到第一个大于 nums[i] + n - 1 的位置 j，那么 j - i 就是当前元素作为最小值时，连续数组的长度，更新答案
        // 即 ans = min(ans, n - (j - i))，最后返回 ans。

        int n = nums.length;

        // 排序并去重
        Arrays.sort(nums);
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }

        //
        int ans = n;
        for (int i = 0, j = 0; i < m; i++) {
            while (j < m && nums[j] - nums[i] <= n - 1) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }

        return ans;
    }
}
