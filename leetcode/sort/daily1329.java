package sort;

import java.util.Arrays;

public class daily1329 {
    public static void main(String[] args) {

    }
}

class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        // 将矩阵按对角线排序
        // 思路：排序

        int m = mat.length;
        int n = mat[0].length;
        int[] a = new int[Math.min(m, n)];
        for (int k = 1 - n; k < m; k++) {
            // k = i - j
            int leftI = Math.max(k, 0);
            int rightI = Math.min(k + n, m);
            for (int i = leftI; i < rightI; i++) {
                a[i - leftI] = mat[i][i - k];
            }
            Arrays.sort(a, 0, rightI - leftI);
            for (int i = leftI; i < rightI; i++) {
                mat[i][i - k] = a[i - leftI];
            }
        }

        return mat;
    }
}
