package arraystring;

import java.util.Arrays;

public class daily2007 {
    public static void main(String[] args) {
        Solution2007 solution = new Solution2007();

        // case1
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[] { 1,
                3, 4, 2, 6, 8 })));
        // case2
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[] { 6,
                3, 0, 1 })));
        // case3
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[] { 1
        })));
        // case4
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[] { 2, 1, 2, 4, 2, 4 })));
    }
}

class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        // 从双倍数组中还原原数组
        // 思路：排序

        if (changed.length % 2 != 0) {
            return new int[] {};
        }

        int n = changed.length;

        Arrays.sort(changed);
        int[] cnt = new int[changed[n - 1] + 1];
        for (int x : changed) {
            ++cnt[x];
        }

        int[] ans = new int[n >> 1];
        int i = 0;
        for (int x : changed) {
            if (cnt[x] == 0) {
                continue;
            }
            --cnt[x];

            int y = x << 1;
            if (y >= cnt.length || cnt[y] <= 0) {
                return new int[0];
            }
            --cnt[y];

            ans[i++] = x;
        }

        return ans;
    }
}
