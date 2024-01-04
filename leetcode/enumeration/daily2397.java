package enumeration;

public class daily2397 {
    public static void main(String[] args) {
        Solution2397 solution = new Solution2397();

        // case1
        System.out.println(solution.maximumRows(new int[][] { { 0, 0, 0 }, { 1, 0, 1 }, { 0, 1, 1 }, { 0, 0, 1 } }, 2));
        // case2
        System.out.println(solution.maximumRows(new int[][] { { 1 }, { 0 } }, 1));
    }
}

class Solution2397 {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] |= 1 << j;
                }
            }
        }

        int ans = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (Integer.bitCount(mask) != numSelect) {
                continue;
            }
            int t = 0;
            for (int x : rows) {
                if ((x & mask) == x) {
                    ++t;
                }
            }
            ans = Math.max(ans, t);
        }

        return ans;
    }
}