package greedy;

import java.util.Arrays;

public class dailylcp40 {
    public static void main(String[] args) {

    }
}

class Solutionlcp40 {
    public int maxmiumScore(int[] cards, int cnt) {
        // 心算挑战
        // 思路：排序 + 贪心
        // 1. 将 cards 从大到小排序，并累加前 cnt 个数，记作 s
        // 2. 如果 s 是偶数，则是最大得分，直接返回 s
        // 3. 如果 s 是奇数，那么可以取下面两种情况的最大值：
        // 3.1 从前 cnt 个数中去掉一个最小的奇数，从后 n - cnt 个数中加进去一个最大的偶数
        // 3.2 从前 cnt 个数中去掉一个最小的偶数，从后 n - cnt 个数中加进去一个最大的奇数

        Arrays.sort(cards);
        int n = cards.length;
        int s = 0;
        for (int i = n - cnt; i < n; i++) {
            s += cards[i]; // 最大的 cnt 个数之和
        }
        if (s % 2 == 0) { // s 是偶数
            return s;
        }

        int x = cards[n - cnt];
        int ans = replacedSum(cards, cnt, s, x); // 替换 x
        for (int i = n - cnt + 1; i < n; i++) {
            if (cards[i] % 2 != x % 2) { // 找到一个最小的奇偶性和 x 不同的数
                ans = Math.max(ans, replacedSum(cards, cnt, s, cards[i])); // 替换
                break;
            }
        }

        return ans;
    }

    private int replacedSum(int[] cards, int cnt, int s, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 != x % 2) { // 找到一个最大的奇偶性和 x 不同的数
                return s - x + cards[i]; // 用 cards[i] 替换 s
            }
        }

        return 0;
    }
}
