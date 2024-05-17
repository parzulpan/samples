package fs;

import java.util.ArrayDeque;
import java.util.Deque;

public class daily994 {
    public static void main(String[] args) {
    }
}

class Solution994 {
    public int orangesRotting(int[][] grid) {
        // 腐烂的橘子
        // 思路：BFS

        int m = grid.length, n = grid[0].length;

        // 统计出新鲜橘子的数量，记为 cnt，并且将所有腐烂的橘子的坐标加入队列 q 中。
        Deque<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ++cnt;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        // 广度优先搜索，每一轮搜索，我们将队列中的所有腐烂的橘子向四个方向腐烂新鲜橘子，直到队列为空或者新鲜橘子的数量为 0 为止
        final int[] dirs = { -1, 0, 1, 0, -1 };
        int ans = 0;
        for (; !q.isEmpty() && cnt > 0; ans++) {
            for (int k = q.size(); k > 0; k--) {
                int[] p = q.poll();
                for (int d = 0; d < 4; d++) {
                    int x = p[0] + dirs[d], y = p[1] + dirs[d + 1];
                    if (x >= 0 && x < m &&
                            y >= 0 && y < n &&
                            grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[] { x, y });
                        --cnt;
                    }
                }
            }
        }

        return cnt > 0 ? -1 : ans;
    }
}