package fs;

public class daily419 {
    public static void main(String[] args) {

    }
}

class Solution419 {
    public int countBattleships(char[][] board) {
        // 甲板上的战舰
        // 思路：按照题意遍历即可
        // 1. 遍历矩阵，找到每个战舰的左上角，即当前位置为 X 且上方和左方都不是 X 的位置，将答案加一。
        // 2. 遍历结束后，返回答案即可。

        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                ++ans;
            }
        }

        return ans;
    }
}
