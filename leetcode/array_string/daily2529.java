package array_string;

public class daily2529 {
    public static void main(String[] args) {

    }
}

class Solution2529 {
    public int maximumCount(int[] nums) {
        // 正整数和负整数的最大计数
        // 思路：按题意遍历处理即可

        int positiveCnt = 0, negativeCnt = 0;
        for (int x : nums) {
            if (x > 0) {
                positiveCnt++;
            }
            if (x < 0) {
                negativeCnt++;
            }
        }

        return Math.max(positiveCnt, negativeCnt);
    }
}
