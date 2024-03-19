package fs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class daily310 {
    public static void main(String[] args) {
        Solution310 solution = new Solution310();

        // case1
        System.out.println(solution.findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } }));

        // case2
        System.out.println(
                solution.findMinHeightTrees(6, new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } }));
    }
}

class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 最小高度树
        // 思路：使用拓扑排序算法
        // 1. 如果这棵树节点数=1，则该节点就是最小高度树的根节点
        // 2. 如果这棵树节点数>1，那么叶子节点是只有一个相邻节点的节点，
        // 使用拓扑排序，从外向内剥离叶子节点，当到达最后一层时，剩下的节点就可作为最小高度树的根节点

        if (n == 1) {
            return List.of(0);
        }

        @SuppressWarnings("unchecked")
        // 邻接表
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        // 每个节点的入度
        int[] degree = new int[n];
        // 处理邻接表和入度
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
            ++degree[a];
            ++degree[b];
        }

        // 叶子节点双端队列
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 入度为1，即为叶子节点
            if (degree[i] == 1) {
                q.offerLast(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.clear();
            // bfs
            for (int i = q.size(); i > 0; i--) {
                int a = q.pollFirst();
                ans.add(a);
                for (int b : g[a]) {
                    if (--degree[b] == 1) {
                        q.offerLast(b);
                    }
                }
            }
        }

        return ans;
    }
}
