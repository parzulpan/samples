package greedy;

public class daily2938 {
    public static void main(String[] args) {
        Solution2938 sol = new Solution2938();

        // case1
        System.out.println(sol.minimumSteps("101"));
        // case2
        System.out.println(sol.minimumSteps("100"));
        // case3
        System.out.println(sol.minimumSteps("0111"));
        // case3
        System.out.println(sol.minimumSteps("1110"));
    }
}

class Solution2938 {
    public long minimumSteps(String s) {
        // 区分黑球与白球
        // 思路：贪心
        // 1. 交换完后的最终状态一定是形如 00001111，那么遍历字符串时每碰到一个 0 就贪心的将其往左交换直到它最终的位置。
        // 2. 在遍历到这个 0 时，因为它左边的 0 都已经交换到最终位置了，所以它的左边是一串连续的 1，那么加上 1 的个数即可。

        long ans = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                ans += sum;
            }
        }

        return ans;
    }
}