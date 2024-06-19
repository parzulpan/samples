package sort;

import java.util.Arrays;

public class daily2779 {
    public static void main(String[] args) {

    }
}

class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        // 数组的最大美丽值
        // 思路：排序+滑动窗口
        // 1. 题意等价于：排序后，找最长的连续子数组，其最大值减最小值不超过 2k

        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
