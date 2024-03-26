package graph;

import java.util.Arrays;

public class daily2642 {
    public static void main(String[] args) {

    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 * 
 * 设计可以求最短路径的图类
 * 思路：Dijsktra 算法
 */
class Graph {
    private int n;
    private int[][] g;
    private final int inf = 1 << 29;

    public Graph(int n, int[][] edges) {
        this.n = n;
        g = new int[n][n];
        for (int[] f : g) {
            Arrays.fill(f, inf);
        }
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
        }
    }

    public void addEdge(int[] edge) {
        g[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        int[] dist = new int[this.n];
        boolean[] vis = new boolean[this.n];
        Arrays.fill(dist, inf);
        dist[node1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        return dist[node2] >= inf ? -1 : dist[node2];
    }
}
