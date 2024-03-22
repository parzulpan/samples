package greedy;

public class daily1969 {
    public static void main(String[] args) {

    }
}

class Solution1969 {
    private final int MOD = (int) 1e9 + 7;

    public int minNonZeroProduct(int p) {
        // 数组元素的最小非零乘积
        // 思路：贪心+数学
        // 1. 每一次操作，并不会改变元素的和，而在元素和不变的情况下，要想使得乘积最小，应该尽可能最大化元素的差值。
        // 2. 由于最大的元素为 2^p - 1 无论与哪个元素交换，都不会使得差值变大，因此我们不需要考虑与最大元素交换的情况。
        // 3. 对于 [1, 2^p - 2] 的元素，我们依次将首尾元素两两配对，即 x 与 2^p - 1 - x
        // 进行配置，那么经过若干次操作过后，每一对元素都变成了 (1, 2^p - 2)

        long a = ((1L << p) - 1) % MOD;
        long b = qpow(((1L << p) - 2) % MOD, (1L << (p - 1)) - 1, MOD);
        return (int) (a * b % MOD);

    }

    private long qpow(long a, long n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }
}
