package tree;

import java.util.Arrays;

public class daily1483 {
    public static void main(String[] args) {

    }
}

/**
 * 树节点的第 K 个祖先
 * 思路：动态规划+倍增法
 */
class TreeAncestor {
    private int[][] p;

    public TreeAncestor(int n, int[] parent) {
        p = new int[n][18];
        for (int[] e : p) {
            Arrays.fill(e, -1);
        }
        for (int i = 0; i < n; i++) {
            p[i][0] = parent[i];
        }
        for (int j = 1; j < 18; j++) {
            for (int i = 0; i < n; i++) {
                if (p[i][j - 1] == -1) {
                    continue;
                }
                p[i][j] = p[p[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 17; i >= 0; i--) {
            if (((k >> i) & 1) == 1) {
                node = p[node][i];
                if (node == -1) {
                    break;
                }
            }
        }

        return node;
    }
}
