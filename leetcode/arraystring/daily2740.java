package arraystring;

import java.util.Arrays;

public class daily2740 {
    public static void main(String[] args) {
        Solution2740 solution2740 = new Solution2740();

        // case1
        System.out.println(solution2740.findValueOfPartition(new int[] { 1, 3, 2, 4 }));

        // case2
        System.out.println(solution2740.findValueOfPartition(new int[] { 100, 1, 10 }));

        // case3
        System.out.println(solution2740.findValueOfPartition(new int[] { 59, 76, 2, 26, 49 }));
    }
}

class Solution2740 {
    public int findValueOfPartition(int[] nums) {
        // 找出分区值
        // 思路：排序后遍历

        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.min(ans, Math.abs(nums[i] - nums[i + 1]));
        }

        return ans;
    }
}
