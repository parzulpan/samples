package simulate;

public class daily1599 {
    public static void main(String[] args) {
        Solution1599 solution = new Solution1599();

        // case1
        System.out.println(solution.minOperationsMaxProfit(new int[] { 8, 3 }, 5, 6));
        // case2
        System.out.println(solution.minOperationsMaxProfit(new int[] { 10, 9, 6 }, 6, 4));
        // case3
        System.out.println(solution.minOperationsMaxProfit(new int[] { 3, 4, 0, 5, 1 }, 1, 92));
    }
}

class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        // 最大利润，当前利润
        int mx = 0, t = 0;
        // 等待的游客，当前转的次数
        int wait = 0, i = 0;
        while (wait > 0 || i < customers.length) {
            // // 累加等待的游客以及新到达的游客，然后最多 4 个上摩天轮
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(4, wait);

            ++i;
            // 更新等待的游客数和利润
            wait -= up;
            t += up * boardingCost - runningCost;

            // 记录最大利润预期对应的轮转次数
            if (t > mx) {
                mx = t;
                ans = i;
            }
        }

        return ans;
    }
}
