package arraystring;

import java.util.Arrays;

public class daily724 {
    public static void main(String[] args) {
        Solution724 solution = new Solution724();

        // case1
        System.out.println(solution.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        // case2
        System.out.println(solution.pivotIndex(new int[] { 1, 2, 3 }));
        // case3
        System.out.println(solution.pivotIndex(new int[] { 2, 1, -1 }));
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        // 寻找数组的中心下标
        // 思路：按题意处理即可

        int ans = -1;
        int left = 0, right = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (left == right - nums[i] - left) {
                ans = i;
                break;
            }
            left += nums[i];
        }

        return ans;
    }
}
