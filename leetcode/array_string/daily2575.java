package array_string;

import java.util.Arrays;

public class daily2575 {
    public static void main(String[] args) {
        Solution2575 solution = new Solution2575();

        // case1
        Arrays.stream(solution.divisibilityArray("998244353", 3)).forEach(System.out::print);
        // case2
        System.out.println();
        Arrays.stream(solution.divisibilityArray("1010", 10)).forEach(System.out::print);
    }
}

class Solution2575 {
    public int[] divisibilityArray(String word, int m) {
        // 找出字符串的可整除数组
        // 思路：
        int n = word.length();
        int[] ans = new int[n];
        long x = 0;
        for (int i = 0; i < n; i++) {
            x = (x * 10 + word.charAt(i) - '0') % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }
}
