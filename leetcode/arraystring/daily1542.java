package arraystring;

import java.util.Arrays;

public class daily1542 {
    public static void main(String[] args) {

    }
}

class Solution1542 {
    public int longestAwesome(String s) {
        // 找出最长的超赞子字符串
        // 思路：状态压缩 + 前缀和

        int[] d = new int[1024];
        int st = 0, ans = 1;
        Arrays.fill(d, -1);
        d[0] = 0;
        for (int i = 1; i <= s.length(); ++i) {
            int v = s.charAt(i - 1) - '0';
            st ^= 1 << v;
            if (d[st] >= 0) {
                ans = Math.max(ans, i - d[st]);
            } else {
                d[st] = i;
            }
            for (v = 0; v < 10; ++v) {
                if (d[st ^ (1 << v)] >= 0) {
                    ans = Math.max(ans, i - d[st ^ (1 << v)]);
                }
            }
        }

        return ans;
    }
}
