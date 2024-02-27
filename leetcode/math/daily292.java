package math;

public class daily292 {
    public static void main(String[] args) {
        Solution292 solution = new Solution292();

        // case1
        System.out.println(solution.canWinNim(4));
        // case2
        System.out.println(solution.canWinNim(1));
        // case3
        System.out.println(solution.canWinNim(2));
    }
}

class Solution292 {
    public boolean canWinNim(int n) {
        // 第一个得到 4 的倍数（即 n 能被 4 整除）的将会输掉比赛。
        // 证明：
        // 1. 当 n < 4 时，第一个玩家可以直接拿走所有的石头，所以第一个玩家将会赢得比赛。
        // 2. 当 n = 4，无论第一个玩家选择 1,2,3 哪个数字，第二个玩家总能选择剩下的数字，所以第一个玩家将会输掉比赛。
        // 3. 当 4 < n < 8 时，即 n = 5,6,7，第一个玩家可以相应地将数字减少为 4，那么 4
        // 这个死亡数字给到了第二个玩家，第二个玩家将会输掉比赛。
        // 4. 当 n = 8，无论第一个玩家选择 1,2,3 哪个数字，都会把 4 < n < 8 的数字留给第二个，所以第一个玩家将会输掉比赛。
        // 依次类推，当玩家拿到 n 这个数字，且 n 能被 4 整除，他将会输掉比赛，否则他将赢得比赛。

        return n % 4 != 0;
    }
}
