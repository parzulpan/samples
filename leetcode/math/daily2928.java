package math;

public class daily2928 {
    public static void main(String[] args) {

    }
}

class Solution2928 {
    public int distributeCandies(int n, int limit) {
        // 给小朋友们分糖果 I
        // 思路：数学难推公式。直接暴力吧

        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            n -= i;
            for (int j = 0; j <= limit; j++) {
                n -= j;
                for (int k = 0; k <= limit; k++) {
                    n -= k;
                    if (n == 0) {
                        ans++;
                    }
                    n += k;
                }
                n += j;
            }
            n += i;
        }

        return ans;
    }
}
