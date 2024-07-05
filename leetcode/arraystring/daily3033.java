package arraystring;

public class daily3033 {
    public static void main(String[] args) {

        Solution3033 solution = new Solution3033();

        // case1
        System.out.println(solution.modifiedMatrix(new int[][] { { 3, -1 }, { 5, 2 } }));
    }
}

class Solution3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        // 修改矩阵
        // 思路：按照题意处理即可

        for (int j = 0; j < matrix[0].length; j++) {
            int mx = 0;
            for (int[] row : matrix) {
                mx = Math.max(mx, row[j]);
            }
            for (int[] row : matrix) {
                if (row[j] == -1) {
                    row[j] = mx;
                }
            }
        }

        return matrix;
    }
}
