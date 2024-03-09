package greedy;

public class daily2834 {
    public static void main(String[] args) {
        Solution2834 solution = new Solution2834();

        // case1
        System.out.println(solution.minimumPossibleSum(2, 3));
        // case2
        System.out.println(solution.minimumPossibleSum(3, 3));
        // case3
        System.out.println(solution.minimumPossibleSum(1, 1));
    }
}

class Solution2834 {
    public int minimumPossibleSum(int n, int target) {
        // 找出美丽数组的最小和
        // 思路：贪心 + 数学
        // 1.
        long m = Math.min(target / 2, n);

        return (int) ((m * (m + 1) + (n - m - 1 + target * 2) * (n - m)) / 2 % 1_000_000_007);
    }
}
