package dp;

public class daily1349 {
    public static void main(String[] args) {
        Solution1349 solution = new Solution1349();

        // case1
        System.out.println(solution.maxStudents(new char[][] {
                { '#', '.', '#', '#', '.', '#' },
                { '.', '#', '#', '#', '#', '.' },
                { '#', '.', '#', '#', '.', '#' }
        }));

        // case2
        System.out.println(solution.maxStudents(new char[][] {
                { '.', '#' },
                { '#', '#' },
                { '#', '.' },
                { '#', '#' },
                { '.', '#' }
        }));

        // case3
        System.out.println(solution.maxStudents(new char[][] {
                { '#', '.', '.', '.', '#' },
                { '.', '#', '.', '#', '.' },
                { '.', '.', '#', '.', '.' },
                { '.', '#', '.', '#', '.' },
                { '#', '.', '.', '.', '#' }
        }));

    }
}

class Solution1349 {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    a[i] |= 1 << j;
                }
            }
        }

        int[][] f = new int[m][1 << n];
        for (int j = 1; j < (1 << n); j++) {
            int lb = j & -j;
            f[0][j] = f[0][j & ~(lb * 3)] + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = a[i]; j > 0; j = (j - 1) & a[i]) { // 枚举 a[i] 的子集 j
                f[i][j] = f[i - 1][a[i - 1]]; // 第 i 排空着
                for (int s = j; s > 0; s = (s - 1) & j) { // 枚举 j 的子集 s
                    if ((s & (s >> 1)) == 0) { // s 没有连续的 1
                        int t = a[i - 1] & ~(s << 1 | s >> 1); // 去掉不能坐人的位置
                        f[i][j] = Math.max(f[i][j], f[i - 1][t] + f[0][s]);
                    }
                }
            }
            f[i][0] = f[i - 1][a[i - 1]];
        }

        return f[m - 1][a[m - 1]];
    }
}
