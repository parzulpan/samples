package dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class lc2866 {
    public static void main(String[] args) {
        Solution2866 solution = new Solution2866();

        List<Integer> case1 = Arrays.asList(5, 3, 4, 1, 1);
        System.out.println(solution.maximumSumOfHeights(case1));

        List<Integer> case2 = Arrays.asList(6, 5, 3, 9, 2, 7);
        System.out.println(solution.maximumSumOfHeights(case2));

        List<Integer> case3 = Arrays.asList(3, 2, 5, 5, 2, 3);
        System.out.println(solution.maximumSumOfHeights(case3));
    }
}

class Solution2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();
        Deque<Integer> stk = new ArrayDeque<>();
        int[] left = new int[size];
        int[] right = new int[size];
        Arrays.fill(left, -1);
        Arrays.fill(right, size);

        for (int i = 0; i < size; ++i) {
            Integer x = maxHeights.get(i);
            while (!stk.isEmpty() && maxHeights.get(stk.peek()) > x) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }

        stk.clear();

        for (int i = size - 1; i >= 0; --i) {
            int x = maxHeights.get(i);
            while (!stk.isEmpty() && maxHeights.get(stk.peek()) >= x) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }

        long[] f = new long[size];
        long[] g = new long[size];

        for (int i = 0; i < size; ++i) {
            int x = maxHeights.get(i);
            if (i > 0 && x >= maxHeights.get(i - 1)) {
                f[i] = f[i - 1] + x;
            } else {
                int j = left[i];
                f[i] = 1L * x * (i - j) + (j >= 0 ? f[j] : 0);
            }
        }
        for (int i = size - 1; i >= 0; --i) {
            int x = maxHeights.get(i);
            if (i < size - 1 && x >= maxHeights.get(i + 1)) {
                g[i] = g[i + 1] + x;
            } else {
                int j = right[i];
                g[i] = 1L * x * (j - i) + (j < size ? g[j] : 0);
            }
        }

        long ans = 0;
        for (int i = 0; i < size; i++) {
            ans = Math.max(ans, f[i] + g[i] - maxHeights.get(i));
        }

        return ans;
    }
}