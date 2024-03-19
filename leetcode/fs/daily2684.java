package fs;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class daily2684 {
    public static void main(String[] args) {

    }
}

class Solution2584 {
    public int maxMoves(int[][] grid) {
        // 矩阵中移动的最大次数
        // 思路：BFS

        int m = grid.length, n = grid[0].length;
        Set<Integer> q = IntStream.range(0, m).boxed().collect(Collectors.toSet());
        for (int j = 0; j < n - 1; j++) {
            HashSet<Integer> t = new HashSet<>();
            for (Integer i : q) {
                for (int k = i - 1; k <= i + 1; k++) {
                    if (k >= 0 && k < m && grid[i][j] < grid[k][j + 1]) {
                        t.add(k);
                    }
                }
            }
            if (t.isEmpty()) {
                return j;
            }
            q = t;
        }

        return n - 1;
    }
}
