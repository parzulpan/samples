package fs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class daily2101 {
    public static void main(String[] args) {

    }
}

class Solution2101 {
    public int maximumDetonation(int[][] bombs) {
        // 引爆最多的炸弹
        // 思路：建立有向图+枚举+DFS
        // 1. 将 n 个炸弹看成 n 个节点，如果炸弹 x 可以引爆炸弹 y，则建立 x 到 y 的有向边；
        // 2. 枚举 i 作为最开始引爆的炸弹，从 i 开始 DFS 有向图，统计能访问道节点，更新记录最大值即为结果

        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 建图
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0], dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= r * r) {
                    graph.get(i).add(j); // i 可以引爆 j
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfs(graph, vis, i));
        }

        return ans;
    }

    private int dfs(List<List<Integer>> graph, boolean[] vis, int i) {
        vis[i] = true;
        int cnt = 1;
        for (int j : graph.get(i)) {
            if (!vis[j]) {
                cnt += dfs(graph, vis, j);
            }
        }

        return cnt;
    }
}
