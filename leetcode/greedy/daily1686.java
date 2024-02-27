package greedy;

import java.util.Arrays;

public class daily1686 {
    public static void main(String[] args) {
        Solution1686 solution = new Solution1686();

        // case1
        System.out.println(solution.stoneGameVI(new int[] { 1, 3 }, new int[] { 2, 1 }));
        // case2
        System.out.println(solution.stoneGameVI(new int[] { 1, 2 }, new int[] { 3, 1 }));
        // case3
        System.out.println(solution.stoneGameVI(new int[] { 2, 4, 3 }, new int[] { 1, 6, 7 }));
    }
}

class Solution1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // 贪心 + 排序
        // 核心是：我可以少拿，但是你不能多拿。即 让自己得分最高，同时让对手失分最多。
        int n = aliceValues.length;
        int[][] values = new int[n][0];
        for (int i = 0; i < n; i++) {
            values[i] = new int[] { aliceValues[i] + bobValues[i], i };
        }
        Arrays.sort(values, (a, b) -> b[0] - a[0]);
        int a = 0, b = 0;
        for (int k = 0; k < n; k++) {
            int i = values[k][1];
            if (k % 2 == 0) {
                a += aliceValues[i];
            } else {
                b += bobValues[i];
            }
        }

        return a == b ? 0 : a > b ? 1 : -1;
    }
}
