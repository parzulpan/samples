package math;

import java.util.ArrayList;
import java.util.List;

public class daily2961 {
    public static void main(String[] args) {
        Solution2961 solution = new Solution2961();

        // case1
        System.out.println(solution.getGoodIndices(new int[][] {
                { 30, 5, 43, 2 }, { 15, 50, 35, 41 }, { 45, 34, 41, 32 }, { 14, 37, 33, 13 }, { 6, 8, 1, 53 },
                { 37, 1, 12, 52 }, { 42, 37, 2, 52 }, { 9, 2, 15, 3 }, { 31, 12, 21, 24 }, { 52, 24, 6, 12 },
                { 51, 35, 21, 52 }, { 30, 18, 10, 2 }, { 27, 31, 50, 27 }, { 29, 25, 26, 32 }, { 15, 38, 43, 17 },
                { 22, 12, 16, 43 }, { 48, 9, 15, 6 }, { 41, 26, 22, 21 }, { 41, 49, 52, 26 }, { 53, 38, 9, 33 } }, 1));

    }
}

class Solution2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        // 双模幂运算
        // 思路：按题意处理即可

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; ++i) {
            var e = variables[i];
            int a = e[0], b = e[1], c = e[2], m = e[3];
            if (qpow(qpow(a, b, 10), c, m) == target) {
                ans.add(i);
            }
        }

        return ans;
    }

    private int qpow(long a, int n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }
}
