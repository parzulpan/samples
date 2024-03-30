package dp;

public class daily1997 {
    public static void main(String[] args) {

    }
}

class Solution1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        // 访问完所有房间的第一天
        // 思路：动态规划

        int n = nextVisit.length;
        long[] f = new long[n];
        final int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; ++i) {
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + mod) % mod;
        }
        return (int) f[n - 1];
    }
}