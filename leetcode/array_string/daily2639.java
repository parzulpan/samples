package array_string;

public class daily2639 {
    public static void main(String[] args) {
        Solution2639 solution = new Solution2639();

        // case1
        System.out.println(solution.findColumnWidth(new int[][] { { 1 }, { 22 }, { 333 } }));

        // case2
        System.out.println(solution.findColumnWidth(new int[][] { { -15, 1, 3 }, { 15, 7, 12 }, { 5, 6, -2 } }));
    }
}

class Solution2639 {
    public int[] findColumnWidth(int[][] grid) {
        // 查询网格图中每一列的宽度
        // 思路：按照题意处理即可

        int ans[] = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            int mx = -1;
            for (int i = 0; i < grid.length; i++) {
                mx = Math.max(mx, String.valueOf(grid[i][j]).length());
            }
            ans[j] = mx;
        }

        return ans;
    }
}