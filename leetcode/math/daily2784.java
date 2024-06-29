package math;

public class daily2784 {
    public static void main(String[] args) {

    }
}

class Solution2784 {
    public int countBeautifulPairs(int[] nums) {
        // 美丽下标对的数目
        // 思路：非暴力枚举
        // 1. 由于 nums[i] 的最高位在 [1,9] 中，我们可以在遍历数组的同时，统计最高位的出现次数，
        // 2. 这样就只需枚举 [1,9] 中的与 x mod 10 互质的数，把对应的出现次数加到答案中。

        int ans = 0;
        int[] cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++) {
                if (cnt[y] > 0 && gcd(y, x % 10) == 1) {
                    ans += cnt[y];
                }
            }
            while (x >= 10) {
                x /= 10;
            }
            cnt[x]++;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
