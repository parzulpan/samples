package untag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class daily2846 {
    public static void main(String[] args) {
        Solution2846 solution = new Solution2846();

        // case1
        int[] minOperationsQueries = solution.minOperationsQueries(7,
                new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 2 }, { 5, 6, 2 } },
                new int[][] { { 0, 3 }, { 3, 6 }, { 2, 6 }, { 0, 6 } });
        for (int value : minOperationsQueries) {
            System.out.println(value);
        }
        // case2
        int[] minOperationsQueries2 = solution.minOperationsQueries(8,
                new int[][] { { 1, 2, 6 }, { 1, 3, 4 }, { 2, 4, 6 }, { 2, 5, 3 }, { 3, 6, 6 }, { 3, 0, 8 },
                        { 7, 0, 2 } },
                new int[][] { { 4, 6 }, { 0, 4 }, { 6, 5 }, { 7, 4 } });
        for (int value : minOperationsQueries2) {
            System.out.println(value);
        }
    }
}

class Solution2846 {
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        int m = 32 - Integer.numberOfLeadingZeros(n);
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[][] f = new int[n][m];
        int[] p = new int[n];
        int[][] cnt = new int[n][0];
        int[] depth = new int[n];
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2] - 1;
            g[u].add(new int[] { v, w });
            g[v].add(new int[] { u, w });
        }
        cnt[0] = new int[26];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            f[i][0] = p[i];
            for (int j = 1; j < m; ++j) {
                f[i][j] = f[f[i][j - 1]][j - 1];
            }
            for (var nxt : g[i]) {
                int j = nxt[0], w = nxt[1];
                if (j != p[i]) {
                    p[j] = i;
                    cnt[j] = cnt[i].clone();
                    cnt[j][w]++;
                    depth[j] = depth[i] + 1;
                    q.offer(j);
                }
            }
        }
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            int u = queries[i][0], v = queries[i][1];
            int x = u, y = v;
            if (depth[x] < depth[y]) {
                int t = x;
                x = y;
                y = t;
            }
            for (int j = m - 1; j >= 0; --j) {
                if (depth[x] - depth[y] >= (1 << j)) {
                    x = f[x][j];
                }
            }
            for (int j = m - 1; j >= 0; --j) {
                if (f[x][j] != f[y][j]) {
                    x = f[x][j];
                    y = f[y][j];
                }
            }
            if (x != y) {
                x = p[x];
            }
            int mx = 0;
            for (int j = 0; j < 26; ++j) {
                mx = Math.max(mx, cnt[u][j] + cnt[v][j] - 2 * cnt[x][j]);
            }
            ans[i] = depth[u] + depth[v] - 2 * depth[x] - mx;
        }
        return ans;
    }
}
