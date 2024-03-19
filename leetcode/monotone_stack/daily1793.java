package monotone_stack;

import java.util.ArrayDeque;

public class daily1793 {
    public static void main(String[] args) {
        Solution1793 solution = new Solution1793();

        // case1
        System.out.println(solution.maximumScore(new int[] { 1, 4, 3, 7, 4, 5 }, 3));
        // case2
        System.out.println(solution.maximumScore(new int[] { 5, 5, 4, 5, 4, 1, 1, 1 }, 0));
    }
}

class Solution1793 {
    public int maximumScore(int[] nums, int k) {
        // 好子数组的最大分数
        // 思路：单调栈
        // 1. 枚举数组的每个元素作为子数组的最小值 nums[i]
        // 2. 利用单调栈找出其左边第一个小于 nums[i] 的位置 left，再找出其右边第一个小于 nums[i] 的位置 right
        // 3. 最后结果为 nums[i] * (right - left - 1)，要注意 left right 的边界问题

        int n = nums.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        // 单调栈找 left 放在数组里
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!st.isEmpty() && x <= nums[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // 单调栈找 right 放在数组里
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            while (!st.isEmpty() && x < nums[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 满足条件则更新
            if (left[i] < k && k < right[i]) {
                ans = Math.max(ans, nums[i] * (right[i] - left[i] - 1));
            }
        }

        return ans;
    }
}
