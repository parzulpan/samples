package tree;

public class daily2673 {
    public static void main(String[] args) {
        Solution2673 solution = new Solution2673();

        // case1
        System.out.println(solution.minIncrements(7, new int[] { 1, 5, 2, 2, 3, 3, 1 }));
        // case2
        System.out.println(solution.minIncrements(3, new int[] { 5, 3, 3 }));
    }
}

class Solution2673 {
    public int minIncrements(int n, int[] cost) {
        // 使二叉树所有路径值相等的最小代价
        // 思路：贪心
        int ans = 0;
        for (int i = n >> 1; i > 0; --i) {
            int l = i << 1, r = i << 1 | 1;
            ans += Math.abs(cost[l - 1] - cost[r - 1]);
            cost[i - 1] += Math.max(cost[l - 1], cost[r - 1]);
        }

        return ans;
    }
}
