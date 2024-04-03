package greedy;

import java.util.Arrays;

public class daily2952 {
    public static void main(String[] args) {

    }
}

class Solution2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        // 需要添加的硬币的最小数量
        // 思路：贪心+构造

        Arrays.sort(coins);
        int ans = 0;
        for (int i = 0, s = 1; s <= target;) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                s <<= 1;
                ++ans;
            }
        }
        return ans;
    }
}
