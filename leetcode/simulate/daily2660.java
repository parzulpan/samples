package simulate;

public class daily2660 {
    public static void main(String[] args) {
        Solution2660 solution = new Solution2660();

        // case1
        System.out.println(solution.isWinner(new int[] { 4, 10, 7, 9 }, new int[] { 6, 5, 2, 3 }));

        // case2
        System.out.println(solution.isWinner(new int[] { 3, 5, 7, 6 }, new int[] { 8, 10, 10, 2 }));

        // case3
        System.out.println(solution.isWinner(new int[] { 2, 3 }, new int[] { 4, 1 }));

        // case4
        System.out.println(solution.isWinner(new int[] { 3, 6, 10, 8 }, new int[] { 9, 9, 9, 9 }));

    }
}

class Solution2660 {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = score(player1);
        int score2 = score(player2);

        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        } else {
            return 0;
        }
    }

    private int score(int[] player) {
        int index = -3;
        int score = 0;
        for (int i = 0; i < player.length; i++) {
            if (i - index <= 2) {
                score += (2 * player[i]);
            } else {
                score += player[i];
            }

            if (player[i] == 10) {
                index = i;
            }
        }

        return score;
    }
}
