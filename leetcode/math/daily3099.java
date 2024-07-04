package math;

public class daily3099 {
    public static void main(String[] args) {
        Solution3099 solution = new Solution3099();

        // case1
        System.out.println(solution.sumOfTheDigitsOfHarshadNumber(18));
        // case1
        System.out.println(solution.sumOfTheDigitsOfHarshadNumber(23));
    }
}

class Solution3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        // 哈沙德数
        // 思路：按照题意处理即可

        int ans = 0;
        int t = x;
        while (t > 0) {
            ans += t % 10;
            t = t / 10;
        }
        return x % ans == 0 ? ans : -1;
    }
}
