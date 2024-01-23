package enumeration;

public class daily2765 {
    public static void main(String[] args) {
        Solution2765 solution = new Solution2765();

        // case1
        System.out.println(solution.alternatingSubarray(new int[] { 2, 3, 4, 3, 4 }));
        // case2
        System.out.println(solution.alternatingSubarray(new int[] { 4, 5, 6 }));
    }
}

class Solution2765 {
    public int alternatingSubarray(int[] nums) {
        int ans = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = 1;
            int j = i;
            for (; j + 1 < n && nums[j + 1] - nums[j] == k; j++) {
                k *= -1;
            }
            if (j - i + 1 > 1) {
                ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }
}
