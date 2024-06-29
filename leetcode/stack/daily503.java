package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class daily503 {
    public static void main(String[] args) {

    }
}

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        // 下一个更大元素 II
        // 思路：单调栈

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = nums[i % n];
            while (!st.isEmpty() && x >= st.peek()) {
                // 由于 x 的出现，栈顶元素永远不会是左边元素的 下一个更大元素
                st.pop();
            }
            if (i < n && !st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(x);
        }

        return ans;
    }
}
